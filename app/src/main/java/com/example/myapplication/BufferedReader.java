package com.example.myapplication;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class BufferedReader extends Service {
    public BufferedReader() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        throw new UnsupportedOperationException("Not yet implemented");

    }
    public int onStartCommand(Intent intent, int flags, int startId) {


        Context context=getApplicationContext();
        String filename = "myfile";

        File file = new File(context.getFilesDir(), filename);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else {


            FileInputStream fis = null;
            try {
                fis = context.openFileInput(filename

                );
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

                    InputStreamReader inputStreamReader =
                    new InputStreamReader(fis, StandardCharsets.UTF_8);
            StringBuilder stringBuilder = new StringBuilder();
            try (java.io.BufferedReader reader = new java.io.BufferedReader(inputStreamReader)) {
                String line = reader.readLine();
                while (line != null) {
                    stringBuilder.append(line).append('\n');
                    line = reader.readLine();
                }
            } catch (IOException e) {
                // Error occurred when opening raw file for reading.
            } finally {
                String contents = stringBuilder.toString();
                Log.d("contents",contents );
            }

        }



        return  START_STICKY;
    }

}