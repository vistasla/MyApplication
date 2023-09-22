package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class NotificationServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_service);
    }
    public void sendMessage(View view) throws IOException {
        Intent intent=new Intent(this, NotificationService.class);
        startService(intent);
    }
}