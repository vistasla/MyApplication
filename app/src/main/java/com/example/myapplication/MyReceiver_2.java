package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MyReceiver_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_receiver2);
    }
    protected void onStart() {
        super.onStart();
        BroadcastReceiver br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context.getApplicationContext(), " Receiver starting", Toast.LENGTH_LONG).show();
                Log.d("MyReceiver_2", " Receiver starting");
                Intent intent1=new Intent(context.getApplicationContext(),ImageViewActivity.class);
                startActivity(intent1);
            }
        };
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("com.example.broadcast.MY_NOTIFICATION");
        //filter.setPriority();
        this.registerReceiver(br, filter);

    }
    public void sendMessage(View view) throws IOException {

        Intent intent=new Intent();
        intent.setAction("com.example.broadcast.MY_NOTIFICATION");
        //sendOrderedBroadcast(intent, null );
        sendBroadcast(intent);
       // LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);

       // LocalBroadcastManager.getInstance(MyReceiver_2.this).sendBroadcast(intent);
    }



}