package com.example.myapplication;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class BufferedReader_readLine_1 extends Service {
    public BufferedReader_readLine_1() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public int onStartCommand(Intent intent, int flags, int startId) {

       /* Log.d("MyService","onStartCommand_begin");

        Context context=getApplicationContext();

        String inputfilename = "inputfile";
        String outputfilename = "outputfile";

        File inputfile = new File(context.getFilesDir(), inputfilename);
        File outputfile = new File(context.getFilesDir(), outputfilename);
        String strContents="outputfile11111";

        byte[] bytes=new byte[1024];

        if(!outputfile.exists()){
            try {
                outputfile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            Log.d("begininput", String.valueOf(outputfile.length()));
            try {
                FileInputStream fileInputStream=new FileInputStream(outputfile);

                InputStreamReader inputStreamReader =
                        new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                Log.d("inputStreamReader", String.valueOf(inputStreamReader.getEncoding()));

                StringBuilder stringBuilder = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
                    String line = reader.readLine();
                    //System.out.println("reader = " + reader.lines());

                    while (line != null) {
                        stringBuilder.append(line).append('\n');
                        line = reader.readLine();
                    }
                } catch (IOException e) {
                    // Error occurred when opening raw file for reading.
                } finally {
                    String contents = stringBuilder.toString();
                    Log.d("inputcompleted", contents);
                }







            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
*/



        return  START_STICKY;
    }
}