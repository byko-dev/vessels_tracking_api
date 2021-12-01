package com.byko.vessel_tracking.database;

import com.byko.vessel_tracking.models.Coordinates;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vessel_tracking_data")
public class VesselTrackingData {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String shipName;
    private String destination;
    private String country;
    private Date eta;

    private double coordinateX;
    private double coordinateY;

    private String callSign; //International radio call sign, up to seven characters, assigned to the vessel by its country of registry
    private double destinationCoordinateX;
    private double destinationCoordinateY;
    private boolean isSurvey;

    @Column(length = Integer.MAX_VALUE)
    private int imo; //IMO (International Maritime Organization) number

    private int shipType;

    @Column(length = Integer.MAX_VALUE)
    private int mmsi; //Maritime Mobile Service Identity

    private double draught;

    @ElementCollection
    private List<Double> coordinatesX;

    @ElementCollection
    private List<Double> coordinatesY;

    private String lastUpdate;

    public VesselTrackingData(String shipName, String destination, String country, Date eta, double coordinateX,
                              double coordinateY, String callSign, double destinationCoordinateX, double destinationCoordinateY,
                              boolean isSurvey, int imo, int shipType, int mmsi, double draught, List<Double> coordinatesX,
                              List<Double> coordinatesY, String lastUpdate) {
        this.shipName = shipName;
        this.destination = destination;
        this.country = country;
        this.eta = eta;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.callSign = callSign;
        this.destinationCoordinateX = destinationCoordinateX;
        this.destinationCoordinateY = destinationCoordinateY;
        this.isSurvey = isSurvey;
        this.imo = imo;
        this.shipType = shipType;
        this.mmsi = mmsi;
        this.draught = draught;
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.lastUpdate = lastUpdate;
    }

    public VesselTrackingData(){}

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public double getDestinationCoordinateX() {
        return destinationCoordinateX;
    }

    public void setDestinationCoordinateX(double destinationCoordinateX) {
        this.destinationCoordinateX = destinationCoordinateX;
    }

    public double getDestinationCoordinateY() {
        return destinationCoordinateY;
    }

    public void setDestinationCoordinateY(double destinationCoordinateY) {
        this.destinationCoordinateY = destinationCoordinateY;
    }

    public boolean isSurvey() {
        return isSurvey;
    }

    public void setSurvey(boolean survey) {
        isSurvey = survey;
    }

    public int getImo() {
        return imo;
    }

    public void setImo(int imo) {
        this.imo = imo;
    }

    public int getShipType() {
        return shipType;
    }

    public void setShipType(int shipType) {
        this.shipType = shipType;
    }

    public int getMmsi() {
        return mmsi;
    }

    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    public double getDraught() {
        return draught;
    }

    public void setDraught(double draught) {
        this.draught = draught;
    }

    public List<Double> getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(List<Double> coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public List<Double> getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(List<Double> coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
