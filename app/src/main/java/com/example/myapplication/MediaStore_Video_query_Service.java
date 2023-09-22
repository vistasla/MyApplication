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
import java.util.concurrent.TimeUnit;

public class MediaStore_Video_query_Service extends Service {
    public MediaStore_Video_query_Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public int onStartCommand(Intent intent, int flags, int startId) {


// Container for information about each video.
        class Video {
            private final Uri uri;
            private final String name;
            private final int duration;
            private final int size;

            public Video(Uri uri, String name, int duration, int size) {
                this.uri = uri;
                this.name = name;
                this.duration = duration;
                this.size = size;
            }
        }
        List<Video> videoList = new ArrayList<Video>();

        Uri collectionUri;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            collectionUri = MediaStore.Video.Media.getContentUri(MediaStore.VOLUME_EXTERNAL);
        } else {
            collectionUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }

        String[] projection = new String[] {
                MediaStore.Video.Media._ID,
                MediaStore.Video.Media.DISPLAY_NAME,
                MediaStore.Video.Media.DURATION,
                MediaStore.Video.Media.SIZE
        };
        String selection = MediaStore.Video.Media.DURATION +
                " >= ?";
        String[] selectionArgs = new String[] {
                String.valueOf(TimeUnit.MILLISECONDS.convert(5, TimeUnit.MINUTES))
        };
        String sortOrder = MediaStore.Video.Media.DISPLAY_NAME + " ASC";

        Cursor cursor = getApplicationContext().getContentResolver().query(
                collectionUri,
                projection,
                selection,
                selectionArgs,
                sortOrder
        );
        Toast.makeText(getApplicationContext(),"cursor.getCount()"+cursor.getCount() , Toast.LENGTH_LONG).show();
            // Cache column indices.
            int idColumn = cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID);
            int nameColumn =
                    cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME);
            int durationColumn =
                    cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION);
            int sizeColumn = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE);

            while (cursor.moveToNext()) {
                // Get values of columns for a given video.
                long id = cursor.getLong(idColumn);
                String name = cursor.getString(nameColumn);
                int duration = cursor.getInt(durationColumn);
                int size = cursor.getInt(sizeColumn);
                Uri contentUri = ContentUris.withAppendedId(
                        MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id);

                // Stores column values and the contentUri in a local object
                // that represents the media file.
                videoList.add(new Video(contentUri, name, duration, size));

            }
            Toast.makeText(getApplicationContext(),"videoList.size()"+videoList.size() , Toast.LENGTH_LONG).show();


        return  START_STICKY;
    }
}