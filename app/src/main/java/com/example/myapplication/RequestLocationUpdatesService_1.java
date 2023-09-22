package com.example.myapplication;

import static android.location.LocationManager.KEY_PROXIMITY_ENTERING;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class RequestLocationUpdatesService_1 extends Service {
    int i=0;
    int j=0;
    Location location;
    boolean aBoolean;
    @Override
    public void onCreate() {

        i++;

        Log.d("RequestLocationUpdatesService_1_i:", String.valueOf(i));
    }
    public RequestLocationUpdatesService_1() {

    }
    private final IBinder binder = new RequestLocationUpdatesService_1.LocalBinder();
    // Random number generator
    private final Random mGenerator = new Random();
    public class LocalBinder extends Binder {
        RequestLocationUpdatesService_1 getService() {
            // Return this instance of LocalService so clients can call public methods
            return RequestLocationUpdatesService_1.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return binder;


    }
    public boolean getRandomNumber() {
        return aBoolean;

    }
    public int onStartCommand(Intent intent, int flags, int startId) {
           /* Log.d("RequestLocationUpdatesService:" , String.valueOf(intent.getBooleanExtra(KEY_PROXIMITY_ENTERING,false)));
aBoolean=intent.getBooleanExtra(KEY_PROXIMITY_ENTERING,false);*/
        j++;

        Log.d("RequestLocationUpdatesService_1_j:", String.valueOf(j));
        return  START_STICKY;
    }



}