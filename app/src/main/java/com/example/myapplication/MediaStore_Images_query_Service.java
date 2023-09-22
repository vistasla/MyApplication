package com.example.myapplication;

import android.app.Service;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.provider.MediaStore;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MediaStore_Images_query_Service extends Service {
    public MediaStore_Images_query_Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public int onStartCommand(Intent intent, int flags, int startId) {

// Container for information about each Images.
        class Images {
            private final Uri uri;
            private final String name;
            private final int duration;
            private final int size;

            public Images(Uri uri, String name, int duration, int size) {
                this.uri = uri;
                this.name = name;
                this.duration = duration;
                this.size = size;
            }
        }
        List<Images> ImagesList = new ArrayList<Images>();

        Uri collectionUri;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            collectionUri = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL);
            /* collectionUri = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_INTERNAL);
            collectionUri = MediaStore.Images.Media.INTERNAL_CONTENT_URI;*/
        } else {
            collectionUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }

        /*String strImages="/storage/emulated/0/Pictures";
        ///storage/emulated/0/Pictures/IMG_20230102_135257.jpg
        File file=new File(strImages+"/IMG_20230102_135257_1.jpg");
        if (file.exists()){

            System.out.println("file exists");
            System.out.println( file.canRead());
            System.out.println( file.canWrite());

        }else{
            System.out.println("file doesn't exists");

            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }*/

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
                /*String.valueOf(TimeUnit.MILLISECONDS.convert(5, TimeUnit.MINUTES))};*/
                String.valueOf(0)};
        String sortOrder = MediaStore.Images.Media.DISPLAY_NAME + " ASC";

        Cursor cursor = getApplicationContext().getContentResolver().query(
                collectionUri,
                projection,
                selection,
                selectionArgs,
                sortOrder
        );
        /*contentResolver.refresh(collectionUri,null,null);*/
        /*contentResolver.insert(collectionUri,)*/
        /*contentResolver.openInputStream();*/
        /*ContentValues contentValues=new ContentValues();*/
        Toast.makeText(getApplicationContext(),"cursor.getCount()"+cursor.getCount() , Toast.LENGTH_LONG).show();

            // cursor
            // Cache column indices.
            int idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID);
            int nameColumn =
                    cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME);
            int durationColumn =
                    cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DURATION);
            int sizeColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE);

            while (cursor.moveToNext()) {
                // Get values of columns for a given Images.
                long id = cursor.getLong(idColumn);
                String name = cursor.getString(nameColumn);
                int duration = cursor.getInt(durationColumn);
                int size = cursor.getInt(sizeColumn);
                Uri contentUri = ContentUris.withAppendedId(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id);

                // Stores column values and the contentUri in a local object
                // that represents the media file.
                ImagesList.add(new Images(contentUri, name, duration, size));

            }
        Toast.makeText(getApplicationContext(),"ImagesList.size()"+ImagesList.size() , Toast.LENGTH_LONG).show();

        return  START_STICKY;
    }
}
