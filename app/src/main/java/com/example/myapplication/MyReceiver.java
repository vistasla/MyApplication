package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context.getApplicationContext(), " MyReceiver starting", Toast.LENGTH_LONG).show();
        Log.d("MyReceiver", " MyReceiver starting");
        throw new UnsupportedOperationException("Not yet implemented");

    }
}