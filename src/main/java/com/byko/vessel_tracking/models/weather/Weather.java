package com.byko.vessel_tracking.models.weather;

public class Weather {
    public Request request;
    public Location location;
    public Current current;

    public Weather(Request request, Location location, Current current) {
        this.request = request;
        this.location = location;
        this.current = current;
    }

    public Weather(){}

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }
}
