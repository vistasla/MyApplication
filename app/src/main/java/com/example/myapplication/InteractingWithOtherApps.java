package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class InteractingWithOtherApps extends AppCompatActivity {
    Intent invokeIntent;
    public InteractingWithOtherApps(){
        //构造方法里捕获不到窗口组件.
    }
    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interacting_with_other_apps);

        Log.d("InteractingWithOtherApps", "onCreate()");
        /*TextView textView= (TextView) findViewById(R.id.textView4);
        //Intent invokeIntent=getIntent();
        invokeIntent=getIntent();
        int inta=invokeIntent.getIntExtra("inta",1);
        textView.setText(String.valueOf(inta));
        Log.d("InteractingWithOtherApps", "onCreate"+String.valueOf(inta));*/
        //finish();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("InteractingWithOtherApps", "onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("InteractingWithOtherApps", "onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("InteractingWithOtherApps", "onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("InteractingWithOtherApps", "onStop()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("InteractingWithOtherApps", "onRestart()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("InteractingWithOtherApps", "onDestroy()");
    }

    public void sendMessage(View view) throws IOException {

    }

    protected void onNewIntent() {
        super.onNewIntent(invokeIntent);
        TextView textView= (TextView) findViewById(R.id.textView4);
        setIntent(getIntent());
        invokeIntent=getIntent();
        int inta=invokeIntent.getIntExtra("inta",1);
        textView.setText(String.valueOf(inta));
        Log.d("InteractingWithOtherApps", "onNewIntent"+String.valueOf(inta));
    }
}