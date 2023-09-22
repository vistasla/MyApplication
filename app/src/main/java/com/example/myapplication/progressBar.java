package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class progressBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);
    }
    protected void onPause(Bundle savedInstanceState) {


    }
    public progressBar(){



    }
    public void sendMessage(View view) throws IOException {

        ProgressBar progressBar=(ProgressBar)findViewById(R.id.progressBar3);
        progressBar.setProgress(100);
    }
}