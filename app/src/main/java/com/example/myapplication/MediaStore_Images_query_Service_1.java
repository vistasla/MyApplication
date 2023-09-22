package com.example.myapplication;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.provider.MediaStore;
import android.widget.Toast;

public class MediaStore_Images_query_Service_1 extends Service {
    public MediaStore_Images_query_Service_1() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        Uri collectionUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
         /* collectionUri = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_INTERNAL);
            collectionUri = MediaStore.Images.Media.INTERNAL_CONTENT_URI;*/
        String[] projection = new String[] {
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.DURATION,
                MediaStore.Images.Media.SIZE
        };
        /*String selection = MediaStore.Images.Media.DURATION +
                " >= ?";*/
        String selection = MediaStore.Images.Media.SIZE +
                " >= ?";
        String[] selectionArgs = new String[] {
                //String.valueOf(TimeUnit.MILLISECONDS.convert(5, TimeUnit.MINUTES))};
                String.valueOf(0)};
        String sortOrder = MediaStore.Images.Media.DISPLAY_NAME + " ASC";
        ContentResolver contentResolver=getApplicationContext().getContentResolver();
        Cursor cursor = contentResolver.query(
                collectionUri,
                null,
                null,
                null,
                null);

        /*Toast.makeText(getApplicationContext(),"contentResolver.refresh"+ contentResolver.refresh(collectionUri,null,null), Toast.LENGTH_LONG).show();*/
        /*contentResolver.insert(collectionUri,)*/
        /*contentResolver.openInputStream();*/
        /*ContentValues contentValues=new ContentValues();*/

        Toast.makeText(getApplicationContext(),"cursor.getCount()"+cursor.getCount() , Toast.LENGTH_LONG).show();
        int i= cursor.getColumnCount();
        for (int j = 0; j <i ; j++) {
           // System.out.println(j+":"+cursor.getColumnName(j));
        }
        while (cursor.moveToNext()) {
            String data = cursor.getString(32);
           /* Toast.makeText(getApplicationContext(),data , Toast.LENGTH_LONG).show();*/
            System.out.println("data"+":"+data);
        }
        return  START_STICKY;
    }
}