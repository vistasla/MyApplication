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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileOutputStream_write_ByteArray_off_1 extends Service {
    public FileOutputStream_write_ByteArray_off_1() {
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
        String outputfilename_1 = "outputfile_1";
        File inputfile = new File(context.getFilesDir(), inputfilename);
        File outputfile = new File(context.getFilesDir(), outputfilename);
        File outputfile_1 = new File(context.getFilesDir(), outputfilename_1);
        String strContents="outputfile11111";

        byte[] bytes=new byte[1024];

        int n;

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
                FileOutputStream fileOutputStream=new FileOutputStream(outputfile_1);
                // bytes=new byte[fileInputStream.available()];
                while ( ( n=fileInputStream.read(bytes))!=-1) {

                    fileOutputStream.write(bytes,0,n);
                    fileOutputStream.flush();

                }

                fileInputStream.close();
                fileOutputStream.close();

                Log.d("FileOutput","completed" );
                try {
                    FileInputStream fileInputStream1=new FileInputStream(outputfile_1);
                    InputStreamReader inputStreamReader =
                            new InputStreamReader(fileInputStream1, StandardCharsets.UTF_8);
                    StringBuilder stringBuilder = new StringBuilder();
                    try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
                        String line = reader.readLine();
                        while (line != null) {
                            stringBuilder.append(line).append('\n');
                            line = reader.readLine();
                        }
                    } catch (IOException e) {
                        // Error occurred when opening raw file for reading.
                    } finally {
                        String contents = stringBuilder.toString();
                        Log.d("of1inputcompleted", contents);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        return  START_STICKY;
    }}