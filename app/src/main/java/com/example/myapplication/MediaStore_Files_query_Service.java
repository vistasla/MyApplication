package com.example.myapplication;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.provider.MediaStore;
import android.widget.Toast;

public class MediaStore_Files_query_Service extends Service {
    public MediaStore_Files_query_Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        Uri collectionUri= MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL);
        ContentResolver contentResolver=getApplicationContext().getContentResolver();
        Cursor cursor = contentResolver.query(
                collectionUri,
                null,
                null,
                null,
                null);
        Toast.makeText(getApplicationContext(),"cursor.getCount()"+cursor.getCount() , Toast.LENGTH_LONG).show();
        int i= cursor.getColumnCount();
        for (int j = 0; j <i ; j++) {
            System.out.println(j+":"+cursor.getColumnName(j));
        }
        while (cursor.moveToNext()) {
            String data = cursor.getString(32);
            /*Toast.makeText(getApplicationContext(),data , Toast.LENGTH_LONG).show();*/
        }

        // Cache column indices.

        return  START_STICKY;
    }
}