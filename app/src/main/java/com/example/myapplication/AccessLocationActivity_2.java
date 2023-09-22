package com.example.myapplication;

import static android.app.PendingIntent.FLAG_IMMUTABLE;
import static android.app.PendingIntent.FLAG_MUTABLE;
import static android.app.PendingIntent.FLAG_ONE_SHOT;
import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.location.provider.ProviderProperties;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

public class AccessLocationActivity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_location_2);

    }


    protected void onStart() {
        super.onStart();
        Context context = getApplicationContext();




}
}
   /* TextView textView6 = findViewById(R.id.textView6);
    TextView textView7 = findViewById(R.id.textView7);
    TextView textView8 = findViewById(R.id.textView8);
                textView6.setText(String.valueOf(location.getAltitude()));
                textView7.setText(String.valueOf(location.getLatitude()));
                textView8.setText(String.valueOf(location.getLongitude()));

                Log.d("AccessLocationActivity_1:", String.valueOf(location.getAltitude()));
                Log.d("AccessLocationActivity_1:", String.valueOf(location.getLatitude()));
                Log.d("AccessLocationActivity_1:", String.valueOf(location.getLongitude()));*/