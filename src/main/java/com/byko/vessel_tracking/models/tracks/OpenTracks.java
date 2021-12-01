package com.byko.vessel_tracking.models.tracks;

import java.util.Date;
import java.util.List;

public class OpenTracks {
    public int mmsi;
    public Date fromDate;
    public Date toDate;
    public List<Track> tracks;

    public OpenTracks(){}

    public OpenTracks(int mmsi, Date fromDate, Date toDate, List<Track> tracks) {
        this.mmsi = mmsi;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.tracks = tracks;
    }

    public int getMmsi() {
        return mmsi;
    }

    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
