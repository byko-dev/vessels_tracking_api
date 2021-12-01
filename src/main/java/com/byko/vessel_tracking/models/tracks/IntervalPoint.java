package com.byko.vessel_tracking.models.tracks;

import java.util.Date;

public class IntervalPoint {

    public double cog;
    public double heading;
    public double lat;
    public double lon;
    public Date msgt;
    public double rot;
    public double sog;


    public IntervalPoint(){}

    public IntervalPoint(double cog, double heading, double lat, double lon, Date msgt, double rot, double sog) {
        this.cog = cog;
        this.heading = heading;
        this.lat = lat;
        this.lon = lon;
        this.msgt = msgt;
        this.rot = rot;
        this.sog = sog;
    }

    public double getCog() {
        return cog;
    }

    public void setCog(double cog) {
        this.cog = cog;
    }

    public double getHeading() {
        return heading;
    }

    public void setHeading(double heading) {
        this.heading = heading;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public Date getMsgt() {
        return msgt;
    }

    public void setMsgt(Date msgt) {
        this.msgt = msgt;
    }

    public double getRot() {
        return rot;
    }

    public void setRot(double rot) {
        this.rot = rot;
    }

    public double getSog() {
        return sog;
    }

    public void setSog(double sog) {
        this.sog = sog;
    }
}
