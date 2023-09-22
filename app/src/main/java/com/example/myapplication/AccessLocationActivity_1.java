package com.example.myapplication;

import static android.app.PendingIntent.FLAG_MUTABLE;
import static android.app.PendingIntent.getActivity;
import static android.app.PendingIntent.getService;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.function.Consumer;

public class AccessLocationActivity_1 extends AppCompatActivity {
    LocationManager locationManager;
    LocationRequest locationRequest;
    PendingIntent pendingIntent;
    Context context;
    Consumer<Location> locationConsumer;
    public Location currentLocation;
    Intent intent;
    Intent intent1;
    String indicator="null";
    float offset=0;
    TextView textView9;
    LocationListener  locationListener=new LocationListener() {

        //Log.d("LocationListener:", "location");

        @SuppressLint("MissingPermission")
        @Override
        public void onLocationChanged(@NonNull Location location) {

switch (indicator)

            {
                case  "distanceTo":

                    TextView textView20= findViewById(R.id.distanceTo_2);
                    textView20.setText(String.valueOf(location.distanceTo(currentLocation)));
                    break;

                case "distanceBetween":
                    float[] floats= {0,0,0};
            location.distanceBetween(currentLocation.getLatitude(),currentLocation.getLongitude(),location.getLatitude(),location.getLongitude(),floats);
                    TextView textView19= findViewById(R.id.distanceBetween_2);
                    textView19.setText(String.valueOf(floats[0]));
                    if(floats[0]>offset){
                        offset=floats[0];

                        textView9.setText(String.valueOf(offset));
                    }

                    break;
                case "addProximityAlert":
                    //immediately
                    locationManager.addProximityAlert(currentLocation.getLatitude(),currentLocation.getLongitude(),1000,-1,pendingIntent);
                    Log.d("addProximityAlert:","1");
                    if (isBinded){
                        setText();
                    }else{
                        intent1=new Intent(getApplicationContext(),RequestLocationUpdatesService.class);
                        //immediately
                        bindService(intent1, connection, Context.BIND_AUTO_CREATE);
                        Log.d("bindService:", "3");
                        if (isBinded){

                            setText();
                            Log.d("setText", "9");

                        }
                    }
                    break;
                default:
                    break;
            }
        }
    };;
    RequestLocationUpdatesService requestLocationUpdatesService;
    boolean isBinded= false;
    ServiceConnection connection = new ServiceConnection() {

        public void onServiceConnected(ComponentName className, IBinder service) {

            // We've bound to LocalService, cast the IBinder and get LocalService instance
            RequestLocationUpdatesService.LocalBinder binder = (RequestLocationUpdatesService.LocalBinder) service;
            requestLocationUpdatesService= binder.getService();
            isBinded = true;
            Log.d("onServiceConnected", "2");
        }

        public void onServiceDisconnected(ComponentName arg0) {
            //requestLocationUpdatesService = null;
            isBinded = false;
            Log.d("onServiceDisconnected", "5");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_location_4);
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AccessLocationActivity_1", "onStop");
        //requestLocationUpdatesService.stopSelf();
    }

    @SuppressLint("MissingPermission")
    protected void onStart() {
        super.onStart();
        context = getApplicationContext();
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        /*for (int i = 0; i < locationManager.getAllProviders().size(); i++) {
            Log.d("Providers_" + i + ":", locationManager.getAllProviders().get(i));

        };*/

        LocationRequest.Builder builder=new LocationRequest.Builder(1000*3);
        //builder.setMaxUpdateDelayMillis(3);
        builder.setQuality( LocationRequest.QUALITY_HIGH_ACCURACY);
        locationRequest=builder.build();

        intent=new Intent(this, RequestLocationUpdatesService.class);
        //intent=new Intent(this, AddProximityAlertActivity.class);
        pendingIntent=getService(context, 0, intent, FLAG_MUTABLE);
        //pendingIntent=getActivity(context, 0, intent, FLAG_MUTABLE);
         locationConsumer = new Consumer<Location>() {
            @Override
            public void accept(Location location) {
                switch (indicator)

                {
                    /*case "addProximityAlert":
                        locationManager.addProximityAlert(location.getLatitude(),location.getLongitude(),1,-1,pendingIntent);
                        break;*/

                    default:

                        break;
                }

                currentLocation=location;
                TextView textView6 = findViewById(R.id.Altitude);
                TextView textView7 = findViewById(R.id.Latitude);
                TextView textView8 = findViewById(R.id.Longitude);
                textView6.setText(String.valueOf(location.getAltitude()));
                textView7.setText(String.valueOf(location.getLatitude()));
                textView8.setText(String.valueOf(location.getLongitude()));

                Log.d("locationConsumer:", String.valueOf(location.getAltitude()));
                Log.d("locationConsumer:", String.valueOf(location.getLatitude()));
                Log.d("locationConsumer:", String.valueOf(location.getLongitude()));
            }}
            ;
         //textView9= findViewById(R.id.textView9);
         //locationManager.requestFlush();
         //ProviderProperties providerProperties= locationManager.getProviderProperties("gps");

    }

    @SuppressLint("MissingPermission")
    public void getCurrentLocation(View view) throws IOException {
        locationManager.getCurrentLocation("fused",null,context.getMainExecutor(),locationConsumer);
    }
    @SuppressLint("MissingPermission")
    public void requestLocationUpdates(View view) throws IOException {
        indicator="requestLocationUpdates";
        //indicator=getCurrentFocus().toString();
        //Log.d("Providers_:",indicator);

        //locationManager.requestLocationUpdates("fused",locationRequest,pendingIntent);
        locationManager.requestLocationUpdates ("fused",locationRequest,context.getMainExecutor(), locationListener);

    }
    @SuppressLint("MissingPermission")
    public void distanceBetween(View view) throws IOException {
        indicator="distanceBetween";
        locationManager.requestLocationUpdates ("fused",locationRequest,context.getMainExecutor(), locationListener);
        //locationManager.removeUpdates ( locationListener);
        //locationManager.removeProximityAlert (pendingIntent);


    }
    @SuppressLint("MissingPermission")
    public void distanceTo (View view) throws IOException {
        indicator="distanceTo";
        locationManager.requestLocationUpdates ("fused",locationRequest,context.getMainExecutor(), locationListener);

    }
    @SuppressLint("MissingPermission")
    public void addProximityAlert(View view) throws IOException {
        indicator="addProximityAlert";
//immediately
        locationManager.requestLocationUpdates ("fused",locationRequest,context.getMainExecutor(), locationListener);
        Log.d("requestLocationUpdates:","10");
    }
    public void setText(){
        boolean entering=  requestLocationUpdatesService.getentering();
        TextView textView21= findViewById(R.id.addProximityAlert_2);
        textView21.setText(String.valueOf(entering));
        //immediately
        /*unbindService(connection);
        Log.d("unbindService:","6");
        //immediately
        requestLocationUpdatesService.stopSelf();
        Log.d("stopSelf:","8");*/

    }

}

