package com.example.myapplication;

import static androidx.core.content.ContextCompat.getSystemService;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public class AccessLocationActivity extends AppCompatActivity {

    private static final Object TODO =null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_location);

    }
    @SuppressLint("MissingPermission")
    AccessLocationActivity() {



        /*FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(getApplicationContext());
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, location -> {
                    if (location != null) {
                        // Logic to handle location object.
                        Log.d("AccessLocationActivity:", String.valueOf(location));
                    }
                });*/



    }


}

//Log.d("isGooglePlayServicesAvailable", String.valueOf(isGooglePlayServicesAvailable (this)));

