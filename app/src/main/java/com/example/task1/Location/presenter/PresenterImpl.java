package com.example.task1.Location.presenter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;


import com.example.task1.Location.model.ModelImpl;
import com.example.task1.Location.model.PermissionHandlerImpl;
import com.example.task1.Location.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class PresenterImpl implements Presenter, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener {

    private Context context;
    private Activity activity;
    private ModelImpl model;
    private PermissionHandlerImpl permissionHandlerImpl;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private String latitude;
    private String longitude;
    private View view;


    public PresenterImpl(Context context, Activity activity, View view) {
        this.activity = activity;
        this.context = context;
        this.view = view;
        Toast.makeText(context, " presenter", Toast.LENGTH_LONG).show();
        mLocationRequest = createLocationRequest();
        model = new ModelImpl(this, context, activity);
        model.checkLocationRequirments(Manifest.permission.ACCESS_FINE_LOCATION, mLocationRequest);
    }

    public void startGettingLocation() {
        Toast.makeText(context, " startGettingLocation", Toast.LENGTH_LONG).show();

        mGoogleApiClient = createGoogleApiClient();
        mGoogleApiClient.connect();


    }

    public GoogleApiClient createGoogleApiClient() {
        GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        return mGoogleApiClient;
    }


    public LocationRequest createLocationRequest() {
        LocationRequest mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY); // set the periority to the accuracy of the location.
        mLocationRequest.setInterval(10000);// update location every 1 second.
        mLocationRequest.setFastestInterval(5000);
        Toast.makeText(context, "Location request made", Toast.LENGTH_LONG).show();
        return mLocationRequest;
    }


    @Override
    /*
     * called when the getting location operation failed
     */

    public void failedToGetLocation() {
        view.onNoLocationRecieved("no Location ");
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {


        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        } else {
            //no location
            Toast.makeText(context, "no location", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(context, "connection suspended", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(context, "connection failed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLocationChanged(Location location) {
        // receive location here
        Toast.makeText(context, "onLocationChanged  ---1", Toast.LENGTH_LONG).show();
        latitude = Double.toString(location.getLatitude());
        longitude = Double.toString(location.getLongitude());
        Toast.makeText(context, "onLocationChanged ---2", Toast.LENGTH_LONG).show();
        // call onLocationRecieved after recieving the location
        view.onLocationRecieved(latitude, longitude);
        mGoogleApiClient.disconnect();

    }


}