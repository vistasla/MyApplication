package com.example.myapplication;

import static android.location.LocationManager.KEY_PROXIMITY_ENTERING;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

public class AddProximityAlertActivity extends AppCompatActivity {
    int i=0;
    int j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_proximity_alert);
        i++;

        Log.d("AddProximityAlertActivity_i:", String.valueOf(i));
    }
    @SuppressLint("MissingPermission")
    protected void onStart() {
        super.onStart();
        j++;

        Log.d("AddProximityAlertActivity_j:", String.valueOf(j));

    }
}