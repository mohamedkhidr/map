package com.example.task1.Location.model;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.example.task1.Location.presenter.Presenter;
import com.example.task1.Location.presenter.PresenterImpl;
import com.google.android.gms.location.LocationRequest;

public class ModelImpl implements Model {


    private PresenterImpl presenterImpl;
    private Presenter presenter;
    private Context context;
    private Activity activity;
    private LocationRequest locationRequest;


    public ModelImpl(Presenter iPresenter, Context context, Activity activity) {
        this.activity = activity;
        this.context = context;
        this.presenter = iPresenter;
        Toast.makeText(context, " Model", Toast.LENGTH_LONG).show();
    }

    /*
     * check the permission and the location settings
     */

    @Override
    public void checkLocationRequirments(String permission, LocationRequest locationRequest) {
        this.locationRequest = locationRequest;

        PermissionHandlerImpl.requestPermission(this, context, activity, permission);

    }



    /*
     * called when requesting permission operation completed
     */
    public void onPermissionRequestCompleted(boolean result) {
        if (result)
            checkLocationSetting(locationRequest);
        else
            presenter.failedToGetLocation();


    }
    /*
     * called after checking location setting
     */
    public void onLocationSettingChecked(boolean result) {
        if (result)
            presenter.startGettingLocation();
        else
            presenter.failedToGetLocation();
    }


    public void checkLocationSetting(LocationRequest locationRequest) {
        LocationSettingHandlerImpl.checkLocationSetting(context, activity, locationRequest, this);
    }
}
