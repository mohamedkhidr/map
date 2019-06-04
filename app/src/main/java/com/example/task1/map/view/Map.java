package com.example.task1.map.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.task1.R;
import com.example.task1.map.presenter.Presenter;
import com.example.task1.map.presenter.PresenterImpl;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class Map extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Presenter presenter;
    private double rechargeAmount;
    private LatLng currentLocation;
    private Bundle extras;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        extras = getIntent().getExtras();
        if (extras != null) {
            rechargeAmount = extras.getDouble("rechargeAmount");
            currentLocation = extras.getParcelable("location");
            // and get whatever type user account id is
        }
        presenter = new PresenterImpl(currentLocation,rechargeAmount,this);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        presenter.onGoogleMapRecieved(mMap);
    }


}
