package com.example.myapplication;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_read extends Service {
    public FileReader_read() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("MyService","onStartCommand_begin");

        Context context=getApplicationContext();

        String inputfilename = "inputfile";
        String outputfilename = "outputfile";

        File inputfile = new File(context.getFilesDir(), inputfilename);
        File outputfile = new File(context.getFilesDir(), outputfilename);
        String strContents="outputfile11111";

        char[] chars;

        if(!outputfile.exists()){
            try {
                outputfile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            Log.d("begininput", String.valueOf(outputfile.length()));
            FileReader fileReader= null;

            try {
                fileReader = new FileReader(outputfile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            chars=new char[1];
            try {
                fileReader.read(chars);
                Log.d("completedinput", String.valueOf(chars));
            } catch (IOException e) {
                e.printStackTrace();
            }


        }




        return  START_STICKY;
    }
}