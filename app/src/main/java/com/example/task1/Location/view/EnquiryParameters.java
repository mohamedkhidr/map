package com.example.task1.Location.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.task1.Location.model.LocationSettingHandlerImpl;
import com.example.task1.Location.model.PermissionHandlerImpl;
import com.example.task1.Location.presenter.PresenterImpl;
import com.example.task1.R;
import com.example.task1.map.view.Map;
import com.example.task1.validations.validator;
import com.google.android.gms.maps.model.LatLng;


public class EnquiryParameters extends AppCompatActivity implements View {


    private EditText txtIntput;
    private PresenterImpl presenter;
    private boolean isCheckboxChecked = false;
    private double rechargeAmount;
    ProgressDialog loadingDialog;


    @Override

    // on App creation
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);
        txtIntput = (EditText) findViewById(R.id.txtInput);

        Toast.makeText(this, " onCreate", Toast.LENGTH_LONG).show();


    }



    // the getLocation button listener
    public void OnGetLocationClicked(android.view.View view) {
       String rechargeAmount_text = txtIntput.getText().toString();
        if ( validator.isValidAmountField(this ,rechargeAmount_text , 10 , 2000 )) {
            loadingDialog = ProgressDialog.show(this, "Loading", "Please wait...", true);
            rechargeAmount = Double.parseDouble(rechargeAmount_text);
            if (isCheckboxChecked) {
                Toast.makeText(this, " getLocation", Toast.LENGTH_LONG).show();
                presenter = new PresenterImpl(this, this, this);

            } else {
                onNoLocationRecieved("No location");

            }
        }


    }


    /*

     * called when the location parameters received.
     * @param latitude  the latitude parameter of the current location.
     * @param longitude the longitude parameter of the current location.

     */

    @Override
    public void onLocationRecieved(String latitude, String longitude) {
        //send to intent
        double lat = Double.parseDouble(latitude);
        double lng = Double.parseDouble(longitude);

        Intent thirdActivity = new Intent(this , Map.class);
        thirdActivity.putExtra("rechargeAmount" , rechargeAmount);
        thirdActivity.putExtra("location" , new LatLng(lat,lng));
        loadingDialog.dismiss();
        startActivity(thirdActivity);
    }


    /*

     * called when the getting location operation failed
     * @param message  a message to tell the user that the operation has failed

     */
    @Override
    public void onNoLocationRecieved(String message) {
        //send to intent
        Intent thirdActivity = new Intent(this , Map.class);
        thirdActivity.putExtra("rechargeAmount" , rechargeAmount);
        thirdActivity.putExtra("location" , new LatLng(0,0));
        loadingDialog.dismiss();
        startActivity(thirdActivity);

    }

    /*

     * called to handle the request permission operation
     * @param requestCode  the code used to handle the request with
     * @param permissions  a list of permissions to return the result of requesting them
     * @param grantResults  a list of granted permissions


     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionHandlerImpl.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /*

     * called to handle the check stting operation
     * @param requestCode  the code used to handle the request with
     * @param resultCode  a list of permissions to return the result of requesting them
     * @param intent  a list of granted permissions


     */

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        LocationSettingHandlerImpl.onActivityResult(requestCode, resultCode, data);
    }

    public void OnCheckboxClicked(android.view.View view) {
        isCheckboxChecked = true;
    }
}








