package com.byko.vessel_tracking;

import com.byko.vessel_tracking.database.*;
import com.byko.vessel_tracking.models.Coordinates;
import com.byko.vessel_tracking.models.position.Position;
import com.byko.vessel_tracking.models.vessels.ResponseToken;
import com.byko.vessel_tracking.models.vessels.TrackVessels;
import com.byko.vessel_tracking.models.tracks.OpenTracks;
import com.byko.vessel_tracking.models.weather.Weather;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
@EnableScheduling
public class SchedulingTasks {

    private RestTemplate restTemplate;
    private VesselDataRepository vesselDataRepository;
    private TokenRepository tokenRepository;
    private ApiRepository  apiRepository;
    private WeatherDataRepository weatherDataRepository;

    public SchedulingTasks(VesselDataRepository vesselDataRepository, TokenRepository tokenRepository,
                           ApiRepository apiRepository, WeatherDataRepository weatherDataRepository){
        restTemplate = new RestTemplate();
        this.vesselDataRepository = vesselDataRepository;
        this.tokenRepository = tokenRepository;
        this.apiRepository = apiRepository;
        this.weatherDataRepository = weatherDataRepository;
    }

    private String getBearerTokenContent(){
        //lookin for current token
        for(Token token: tokenRepository.findAll()){
            if(token.getExpiresIn() > System.currentTimeMillis()) return token.getContent();
            else tokenRepository.delete(token); //delete expired tokens
        }

        //if token not found create new token
        ApiCredentials api = apiRepository.findAll().get(0);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_FORM_URLENCODED));

        MultiValueMap<String, String> xWwwFormKeyPair = new LinkedMultiValueMap();
        xWwwFormKeyPair.add("client_id", api.getClient_id());
        xWwwFormKeyPair.add("scope", api.getScope());
        xWwwFormKeyPair.add("client_secret", api.getClient_secret());
        xWwwFormKeyPair.add("grant_type", api.getGrant_type());
        HttpEntity<?> httpEntity = new HttpEntity<>(xWwwFormKeyPair, httpHeaders);

        ResponseEntity<ResponseToken> responseEntity = restTemplate.exchange("https://id.barentswatch.no/connect/token",
                HttpMethod.POST, httpEntity, ResponseToken.class);

        String fullTokenContent = responseEntity.getBody().getToken_type() + " " + responseEntity.getBody().getAccess_token();
        long fullExpireDate = responseEntity.getBody().getExpires_in() * 1000 + System.currentTimeMillis();

        tokenRepository.save(new Token(fullTokenContent, fullExpireDate));

        return fullTokenContent;
    }

    private Coordinates getDestination(String destinationName, String accessKey){
        Coordinates coordinates = new Coordinates();
        try {
            ResponseEntity<Position> responseEntity = restTemplate.exchange(
                    "http://api.positionstack.com/v1/forward?access_key="+accessKey+"&query=" + destinationName,
                    HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), Position.class);

            coordinates.setCoordinateX(responseEntity.getBody().getData().get(0).getLongitude());
            coordinates.setCoordinateY(responseEntity.getBody().getData().get(0).getLatitude());
        } catch (Exception ex) {
            coordinates.setCoordinateX(0);
            coordinates.setCoordinateY(0);
        }
        return coordinates;
    }

    @Scheduled(fixedDelay = 1000*60*10, initialDelay = 1000*5)//execute every 10 minutes
    private void updateVesselTrackingData(){

        String positionstackAccessKey = apiRepository.findAll().get(0).getPositionstackAccessKey();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", getBearerTokenContent());

        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<TrackVessels[]> responseEntity = restTemplate.exchange(
                "https://www.barentswatch.no/bwapi/v2/geodata/ais/openpositions?Xmin=10.09094&Xmax=10.67047&Ymin=63.3989&Ymax=63.58645",
                HttpMethod.GET, httpEntity, TrackVessels[].class);

        for(TrackVessels track: responseEntity.getBody()){

            Coordinates destinationCoordinates = getDestination(track.getDestination(), positionstackAccessKey);

            List<Coordinates> shipTracksLastOneDay = getTracksLastOneDay(track.getMmsi());

            List<Double> coordinatesX = shipTracksLastOneDay.stream()
                    .map(Coordinates::getCoordinateX)
                    .collect(Collectors.toList());

            List<Double> coordinatesY = shipTracksLastOneDay.stream()
                    .map(Coordinates::getCoordinateY)
                    .collect(Collectors.toList());

            //update data existing ships
            for(VesselTrackingData vesselTrackingData : vesselDataRepository.findAll()){
                if(vesselTrackingData.getShipName() != null &&
                        vesselTrackingData.getShipName().equals(track.getName()) &&
                        vesselTrackingData.getMmsi() == track.getMmsi()){

                    vesselTrackingData.setCoordinateY(track.getGeometry().getCoordinates().get(1));
                    vesselTrackingData.setCoordinateX(track.getGeometry().getCoordinates().get(0));
                    vesselTrackingData.setCoordinatesX(coordinatesX);
                    vesselTrackingData.setCoordinatesY(coordinatesY);
                    vesselTrackingData.setSurvey(track.isSurvey());
                    vesselTrackingData.setDestination(track.getDestination());
                    vesselTrackingData.setDestinationCoordinateX(destinationCoordinates.getCoordinateX());
                    vesselTrackingData.setDestinationCoordinateY(destinationCoordinates.getCoordinateY());
                    vesselTrackingData.setEta(track.getEta());
                    vesselTrackingData.setLastUpdate(Utils.setDate());

                    vesselDataRepository.save(vesselTrackingData);
                }
            }

            //save to base new ship
            vesselDataRepository.save(new VesselTrackingData(track.getName(),
                    track.getDestination(),
                    track.getCountry(),
                    track.getEta(),
                    track.getGeometry().getCoordinates().get(0),
                    track.getGeometry().getCoordinates().get(1),
                    track.getCallsign(),
                    destinationCoordinates.getCoordinateX(),
                    destinationCoordinates.getCoordinateY(),
                    track.isSurvey(),
                    track.getImo(),
                    track.getShipType(),
                    track.getMmsi(),
                    track.getDraught(),
                    coordinatesX,
                    coordinatesY,
                    Utils.setDate()));
        }

        System.out.println(Utils.setDate() + " => vesselTrackingUpdated");
    }

    //I have only 250 requests limit per month so update is just every 3 hours
    @Scheduled(fixedDelay = 1000*60*60*3, initialDelay = 1000*5)
    public void updateLocalWeather(){

        String weatherstackAccessToken = apiRepository.findAll().get(0).getWeatherstackAccessKey();

        Weather weather = restTemplate.exchange(
                "http://api.weatherstack.com/current?access_key="+weatherstackAccessToken+"&query=Trolla",
                HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), Weather.class).getBody();

        if (weather != null) {
            //get all aged records
            List<WeatherData> weatherDataList = weatherDataRepository.findAll();

            WeatherData weatherData = new WeatherData();
            weatherData.setTime(weather.getLocation().getLocaltime());
            weatherData.setTemperature(weather.getCurrent().getTemperature());
            weatherData.setWeather_icon_url(weather.getCurrent().getWeather_icons().get(0));
            weatherData.setWeather_descriptions(weather.getCurrent().getWeather_descriptions().get(0));
            weatherData.setWind_speed(weather.getCurrent().getWind_speed());
            weatherData.setWind_degree(weather.getCurrent().getWind_degree());
            weatherData.setWind_dir(weather.getCurrent().getWind_dir());
            weatherData.setIs_day(weather.getCurrent().getIs_day());

            weatherDataRepository.save(weatherData); //save new weather record

            weatherDataRepository.deleteAll(weatherDataList); //delete aged records

            System.out.println(Utils.setDate() + " => weatherUpdated");
        }
    }

    public List<Coordinates> getTracksLastOneDay(int mmsi){

        List<Coordinates> coordinatesList = new ArrayList<>();

        try{
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization", getBearerTokenContent());

            HttpEntity httpEntity = new HttpEntity(httpHeaders);
            ResponseEntity<OpenTracks> responseEntity = restTemplate.exchange("https://www.barentswatch.no/bwapi/v1/geodata/ais/"+mmsi+"/opentracks",
                    HttpMethod.GET, httpEntity, OpenTracks.class);

            for(List<Double> coordinate: responseEntity.getBody().getTracks().get(0).getCoordinates()){
                coordinatesList.add(new Coordinates(coordinate.get(0), coordinate.get(1)));
            }

            return coordinatesList;
        }catch (Exception ex){
            return coordinatesList;
        }
    }

}
