package com.example.task1.Location.presenter;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

public interface Presenter {
    public void startGettingLocation();

    public GoogleApiClient createGoogleApiClient();

    public LocationRequest createLocationRequest();

    public void failedToGetLocation();

}