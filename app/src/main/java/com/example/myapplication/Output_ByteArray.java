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

public class Output_ByteArray extends Service {
    public Output_ByteArray() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        throw new UnsupportedOperationException("Not yet implemented");

    }
    public int onStartCommand(Intent intent, int flags, int startId) {


        Context context=getApplicationContext();
        String filename = "myfile";
        byte[] bytes=new byte[1024];
        int i=0;

        File file = new File(context.getFilesDir(), filename);
        if (!file.exists()){


        }
        else {


            FileInputStream fis = null;
            try {
                fis = context.openFileInput(filename

                );
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while (true) {
                try {
                    if (!(fis.read(bytes)!=-1)){


                        while (i<110){
                            Log.d("contents"+i, String.valueOf(bytes[1]));
                            i++;

                        }

                    }


                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        }



        return  START_STICKY;
    }

}