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

public class FileInputStream_read_ByteArray extends Service {
    public FileInputStream_read_ByteArray() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        throw new UnsupportedOperationException("Not yet implemented");

    }
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("MyService","onStartCommand_begin");
        Context context=getApplicationContext();
        String filename = "myfile";
        byte[] bytes=new byte[1024];

        File file = new File(context.getFilesDir(), filename);
        FileInputStream fileInputStream=null;

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {

            fileInputStream.read(bytes);
            fileInputStream.close();

            Log.d("MyService", String.valueOf(bytes));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  START_STICKY;
    }

}