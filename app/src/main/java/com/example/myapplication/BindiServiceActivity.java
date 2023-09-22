package com.example.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class BindiServiceActivity extends AppCompatActivity {

    BindService bindService;
    boolean isBinded= false;
    ServiceConnection connection = new ServiceConnection() {

        public void onServiceConnected(ComponentName className, IBinder service) {

            // We've bound to LocalService, cast the IBinder and get LocalService instance
            BindService.LocalBinder binder = (BindService.LocalBinder) service;
            bindService = binder.getService();
            isBinded = true;
            Log.d("onServiceConnected", String.valueOf(isBinded));
           /* Toast.makeText(this., String.valueOf(isBinded), Toast.LENGTH_LONG).show();*/

        }

        public void onServiceDisconnected(ComponentName arg0) {
            isBinded = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binding);
    }
    public void sendMessage(View view) throws IOException, InterruptedException {

        Intent intent=new Intent(this,BindService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
        Log.d("bindService",String.valueOf(isBinded) );
        /* false*/

        /*Thread.currentThread().wait(10000);
        Thread.currentThread().sleep(10000);*/
        /*Toast.makeText(this, String.valueOf(isBinded), Toast.LENGTH_LONG).show();*/

    }

    public void sendMessage_1(View view) throws IOException {

        int int0=  bindService.getRandomNumber();

        Toast.makeText(this, String.valueOf(int0), Toast.LENGTH_LONG).show();

    }


}