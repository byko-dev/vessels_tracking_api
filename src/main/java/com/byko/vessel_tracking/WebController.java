package com.byko.vessel_tracking;

import com.byko.vessel_tracking.database.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") //allow all origins (not safe)
public class WebController {

    private VesselDataRepository vesselDataRepository;
    private WeatherDataRepository weatherDataRepository;
    private ApiRepository apiRepository;

    public WebController(VesselDataRepository vesselDataRepository, WeatherDataRepository weatherDataRepository, ApiRepository apiRepository){
        this.vesselDataRepository = vesselDataRepository;
        this.weatherDataRepository = weatherDataRepository;
        this.apiRepository = apiRepository;
    }

    @GetMapping("/vessels/data")
    public List<VesselTrackingData> getToken(){
        return vesselDataRepository.findAll();
    }

    @GetMapping("/local/weather")
    public WeatherData getLocalWeather(){
      return weatherDataRepository.findAll().get(0);
    }
}
