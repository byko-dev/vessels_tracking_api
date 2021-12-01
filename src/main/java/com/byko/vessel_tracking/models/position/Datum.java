package com.byko.vessel_tracking.models.position;

public class Datum {

    public double latitude;
    public double longitude;
    public String type;
    public String name;
    public Object number;
    public Object postal_code;
    public Object street;
    public int confidence;
    public String region;
    public String region_code;
    public String county;
    public String locality;
    public String administrative_area;
    public Object neighbourhood;
    public String country;
    public String country_code;
    public String continent;
    public String label;

    public Datum(double latitude, double longitude, String type, String name, Object number, Object postal_code,
                 Object street, int confidence, String region, String region_code, String county, String locality,
                 String administrative_area, Object neighbourhood, String country, String country_code, String continent,
                 String label) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.name = name;
        this.number = number;
        this.postal_code = postal_code;
        this.street = street;
        this.confidence = confidence;
        this.region = region;
        this.region_code = region_code;
        this.county = county;
        this.locality = locality;
        this.administrative_area = administrative_area;
        this.neighbourhood = neighbourhood;
        this.country = country;
        this.country_code = country_code;
        this.continent = continent;
        this.label = label;
    }

    public Datum(){}

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getNumber() {
        return number;
    }

    public void setNumber(Object number) {
        this.number = number;
    }

    public Object getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(Object postal_code) {
        this.postal_code = postal_code;
    }

    public Object getStreet() {
        return street;
    }

    public void setStreet(Object street) {
        this.street = street;
    }

    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion_code() {
        return region_code;
    }

    public void setRegion_code(String region_code) {
        this.region_code = region_code;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getAdministrative_area() {
        return administrative_area;
    }

    public void setAdministrative_area(String administrative_area) {
        this.administrative_area = administrative_area;
    }

    public Object getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(Object neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
