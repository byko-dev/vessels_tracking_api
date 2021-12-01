package com.byko.vessel_tracking.database;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "weather_data")
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String time;
    private int temperature;

    @Column(name = "icon_url", length = 1024)
    private String weather_icon_url;

    private String weather_descriptions;
    private int wind_speed;
    private int wind_degree;
    private String wind_dir;
    private String is_day;

    public WeatherData(String time, int temperature, String weather_icon_url, String weather_descriptions, int wind_speed, int wind_degree, String wind_dir, String is_day) {
        this.time = time;
        this.temperature = temperature;
        this.weather_icon_url = weather_icon_url;
        this.weather_descriptions = weather_descriptions;
        this.wind_speed = wind_speed;
        this.wind_degree = wind_degree;
        this.wind_dir = wind_dir;
        this.is_day = is_day;
    }

    public WeatherData(){}

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getWeather_icon_url() {
        return weather_icon_url;
    }

    public void setWeather_icon_url(String weather_icon_url) {
        this.weather_icon_url = weather_icon_url;
    }

    public String getWeather_descriptions() {
        return weather_descriptions;
    }

    public void setWeather_descriptions(String weather_descriptions) {
        this.weather_descriptions = weather_descriptions;
    }

    public int getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(int wind_speed) {
        this.wind_speed = wind_speed;
    }

    public int getWind_degree() {
        return wind_degree;
    }

    public void setWind_degree(int wind_degree) {
        this.wind_degree = wind_degree;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getIs_day() {
        return is_day;
    }

    public void setIs_day(String is_day) {
        this.is_day = is_day;
    }
}
