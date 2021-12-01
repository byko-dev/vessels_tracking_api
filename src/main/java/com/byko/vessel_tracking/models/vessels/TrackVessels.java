package com.byko.vessel_tracking.models.vessels;

import com.byko.vessel_tracking.models.vessels.Geometry;

import java.util.Date;

public class TrackVessels {
    public Date timeStamp;
    public double sog;
    public double rot;
    public int navstat;
    public int mmsi;
    public double cog;
    public Geometry geometry;
    public int shipType;
    public String name;
    public int imo;
    public String callsign;
    public String country;
    public Date eta;
    public String destination;
    public boolean isSurvey;
    public int heading;
    public double draught;
    public int a;
    public int b;
    public int c;
    public int d;

    public TrackVessels(Date timeStamp, double sog, double rot, int navstat, int mmsi, double cog,
                        Geometry geometry, int shipType, String name, int imo, String callsign,
                        String country, Date eta, String destination, boolean isSurvey, int heading,
                        double draught, int a, int b, int c, int d) {
        this.timeStamp = timeStamp;
        this.sog = sog;
        this.rot = rot;
        this.navstat = navstat;
        this.mmsi = mmsi;
        this.cog = cog;
        this.geometry = geometry;
        this.shipType = shipType;
        this.name = name;
        this.imo = imo;
        this.callsign = callsign;
        this.country = country;
        this.eta = eta;
        this.destination = destination;
        this.isSurvey = isSurvey;
        this.heading = heading;
        this.draught = draught;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public TrackVessels(){}

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getSog() {
        return sog;
    }

    public void setSog(double sog) {
        this.sog = sog;
    }

    public double getRot() {
        return rot;
    }

    public void setRot(double rot) {
        this.rot = rot;
    }

    public int getNavstat() {
        return navstat;
    }

    public void setNavstat(int navstat) {
        this.navstat = navstat;
    }

    public int getMmsi() {
        return mmsi;
    }

    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    public double getCog() {
        return cog;
    }

    public void setCog(double cog) {
        this.cog = cog;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public int getShipType() {
        return shipType;
    }

    public void setShipType(int shipType) {
        this.shipType = shipType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImo() {
        return imo;
    }

    public void setImo(int imo) {
        this.imo = imo;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getEta() {
        return eta;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean isSurvey() {
        return isSurvey;
    }

    public void setSurvey(boolean survey) {
        isSurvey = survey;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public double getDraught() {
        return draught;
    }

    public void setDraught(double draught) {
        this.draught = draught;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
}
