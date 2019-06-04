package com.example.task1.map.model;

import com.example.task1.map.presenter.Presenter;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {
    private List<LocationPoint> locationPoints;
    private Presenter presenter;

    public ModelImpl(Presenter presenter) {
        this.presenter = presenter;
        locationPoints = new ArrayList<LocationPoint>();
        getPoints();
    }

    @Override
    public void connect() {

    }

    @Override
    public void disConnect() {

    }

    @Override
    public void checkConnectionSetting() {

    }

    @Override
    public void request() {

    }

    @Override
    public void response() {

    }

    @Override
    public void jsonParser() {

    }

    @Override
    public void getPoints() {
        locationPoints.add(new LocationPoint(new LatLng(30.5718291, 31.0081698), 100.0, "khidr"
                , "01143822410", "rreet555678yuii"));
        locationPoints.add(new LocationPoint(new LatLng(30.5717291, 31.0081598), 200.0, "mohamed"
                , "01143822410", "rreet555678yuii"));
        locationPoints.add(new LocationPoint(new LatLng(30.5716291, 31.0081498), 300.0, "ahmed"
                , "01143822410", "rreet555678yuii"));
        locationPoints.add(new LocationPoint(new LatLng(30.5715291, 31.0081398), 400.0, "khalid"
                        , "01143822410", "rreet555678yuii"));
        locationPoints.add(new LocationPoint(new LatLng(30.0595581, 31.2934439), 500.0, "khalid"
                                , "01143822410", "rreet555678yuii"));
        locationPoints.add(new LocationPoint(new LatLng(30.0595581, 31.2934739), 600.0, "khalid"
                                , "01143822410", "rreet555678yuii"));
        presenter.onGettingLocationPoints(locationPoints);

    }
}
