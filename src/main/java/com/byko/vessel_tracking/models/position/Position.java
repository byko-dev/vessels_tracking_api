package com.byko.vessel_tracking.models.position;

import java.util.List;

public class Position {
    public List<Datum> data;

    public Position(List<Datum> data) {
        this.data = data;
    }
    public Position(){}

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }
}
