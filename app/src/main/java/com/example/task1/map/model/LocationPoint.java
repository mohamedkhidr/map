package com.example.task1.map.model;

import com.google.android.gms.maps.model.LatLng;

public class LocationPoint {
    private LatLng coordinates;
    private double maxAmount;
    private String name;
    private String phoneNumber;
    private String id;

    public LocationPoint(LatLng coordinates, double maxAmount, String name, String phoneNumber, String id) {
        this.coordinates = coordinates;
        this.maxAmount = maxAmount;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public LatLng getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(LatLng coordinates) {
        this.coordinates = coordinates;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
