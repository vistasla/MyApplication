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

public class RequestLocationUpdatesService extends Service {
    int i=0;
    int j=0;
    boolean entering;

    public RequestLocationUpdatesService() {

    }
    private final IBinder binder = new RequestLocationUpdatesService.LocalBinder();

    public class LocalBinder extends Binder {
        RequestLocationUpdatesService getService() {
            // Return this instance of LocalService so clients can call public methods
            return RequestLocationUpdatesService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d("RequestLocationUpdatesService:","onBind" );
        return binder;


    }
    @Override
    public boolean onUnbind(Intent intent) {
        // All clients have unbound with unbindService()
        Log.d("RequestLocationUpdatesService:","onUnbind_4" );
        return true;
    }

    @Override
    public void onRebind(Intent intent) {
        // A client is binding to the service with bindService(),
        // after onUnbind() has already been called
        Log.d("RequestLocationUpdatesService:","onRebind" );
    }

    public boolean getentering() {
        return entering;

    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        j++;
        Log.d("onStartCommand:", "0");
        Log.d("RequestLocationUpdatesService_j:", String.valueOf(j));
        Log.d("RequestLocationUpdatesService:" , String.valueOf(intent.getBooleanExtra(KEY_PROXIMITY_ENTERING,false)));
        entering=intent.getBooleanExtra(KEY_PROXIMITY_ENTERING,false);
                /*for (int k = 0; k >-1 ; k++) {
            Log.d("RequestLocationUpdatesService:", String.valueOf(k));
            if(k==1){
            }
        }*/
//stopSelf();
            return  START_STICKY;
        }
    @Override
    public void onCreate() {
        i++;
        Log.d("RequestLocationUpdatesService_i:", String.valueOf(i));
    }
    @Override
    public void onDestroy (){
        Log.d("RequestLocationUpdatesService:", "onDestroy ()_7");
    }

}