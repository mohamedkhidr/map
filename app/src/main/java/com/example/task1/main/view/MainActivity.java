package com.example.task1.main.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.task1.Location.view.EnquiryParameters;
import com.example.task1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnBranchesButtonClicked(View view) {
      Intent secondActivity = new Intent(this , EnquiryParameters.class);
      startActivity(secondActivity);
    }
}
