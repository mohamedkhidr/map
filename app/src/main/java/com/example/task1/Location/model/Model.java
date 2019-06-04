package com.example.task1.Location.model;

import com.google.android.gms.location.LocationRequest;

public interface Model {
    public void checkLocationRequirments(String permission, LocationRequest locationRequest);


    public void onPermissionRequestCompleted(boolean result);

    public void onLocationSettingChecked(boolean result);

}
