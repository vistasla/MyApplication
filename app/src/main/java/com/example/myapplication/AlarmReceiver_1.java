package com.example.myclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver_1 {
    public  AlarmReceiver_1(Context context){
        BroadcastReceiver br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "AlermReceiver_1:AlarmReceiver_1 started", Toast.LENGTH_SHORT).show();
                Log.d("AlarmReceiver_1:","AlarmReceiver_1 started" );
            }
        };
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        /*filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(Intent.ACTION_CREATE_REMINDER);*/
        context.registerReceiver(br, filter);
    }
}
