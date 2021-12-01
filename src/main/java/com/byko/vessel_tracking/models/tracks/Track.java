package com.byko.vessel_tracking.models.tracks;

import java.util.Date;
import java.util.List;

public class Track {

    public int id;
    public Date fromTime;
    public Date toTime;
    public boolean isNoSignal;
    public List<IntervalPoint> intervalPoints;
    public int wellBoatWeekId;
    public List<List<Double>> coordinates;

    public Track(){}

    public Track(int id, Date fromTime, Date toTime, boolean isNoSignal, List<IntervalPoint> intervalPoints, int wellBoatWeekId, List<List<Double>> coordinates) {
        this.id = id;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.isNoSignal = isNoSignal;
        this.intervalPoints = intervalPoints;
        this.wellBoatWeekId = wellBoatWeekId;
        this.coordinates = coordinates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }

    public boolean isNoSignal() {
        return isNoSignal;
    }

    public void setNoSignal(boolean noSignal) {
        isNoSignal = noSignal;
    }

    public List<IntervalPoint> getIntervalPoints() {
        return intervalPoints;
    }

    public void setIntervalPoints(List<IntervalPoint> intervalPoints) {
        this.intervalPoints = intervalPoints;
    }

    public int getWellBoatWeekId() {
        return wellBoatWeekId;
    }

    public void setWellBoatWeekId(int wellBoatWeekId) {
        this.wellBoatWeekId = wellBoatWeekId;
    }

    public List<List<Double>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<Double>> coordinates) {
        this.coordinates = coordinates;
    }
}
