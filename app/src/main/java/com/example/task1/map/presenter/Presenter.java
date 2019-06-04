package com.example.task1.map.presenter;

import com.example.task1.map.model.LocationPoint;

import com.google.android.gms.maps.GoogleMap;

import java.util.List;

public interface Presenter {
    public void setGreenRedPoints ();
    public List<LocationPoint> getRedPoints ();
    public List<LocationPoint> getGreenPoints ();
    public void flyToDefaultLocation();
    public void spreadPointsOnMap();
    public void onGoogleMapRecieved(GoogleMap googleMap);
    public void onGettingLocationPoints(List<LocationPoint> points);

}
