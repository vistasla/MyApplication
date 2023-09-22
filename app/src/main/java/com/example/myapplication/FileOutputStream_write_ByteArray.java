package com.example.myapplication;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileOutputStream_write_ByteArray extends Service {
    public FileOutputStream_write_ByteArray() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public int onStartCommand(Intent intent, int flags, int startId) {



        Context context=getApplicationContext();
        String filename = "myfile";
        String fileContents = "Hello world!";

        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //fos.write(fileContents.toByteArray());
        try {
            fos.write(fileContents.getBytes(StandardCharsets.UTF_8));

            Log.d("FileOutputStream_Write","write_completed");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  START_STICKY;
    }
}