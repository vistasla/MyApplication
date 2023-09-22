package com.example.myapplication;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MediaStore_Images_query_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_store_images_query);
    }
    public void sendMessage(View view) throws IOException, InterruptedException {
        Uri collectionUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection = new String[] {
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.DURATION,
                MediaStore.Images.Media.SIZE
        };
        String selection = MediaStore.Images.Media.SIZE +
                " >= ?";
        String[] selectionArgs = new String[] {
                String.valueOf(0)};
        String sortOrder = MediaStore.Images.Media.DISPLAY_NAME + " ASC";
        ContentResolver contentResolver=getApplicationContext().getContentResolver();
        Cursor cursor = contentResolver.query(
                collectionUri,
                null,
                null,
                null,
                null);
        Toast.makeText(getApplicationContext(),"cursor.getCount()"+cursor.getCount() , Toast.LENGTH_LONG).show();
        int i=0;
        while (cursor.moveToNext()) {
            String data = cursor.getString(32);
            Uri uri=Uri.parse(data);
            ImageView imageView= (ImageView)findViewById(R.id.imageView6);
            imageView.setImageURI(uri);
            TextView textView=(TextView)findViewById(R.id.textView3);
            textView.setText("data"+i+":"+data);
            i++;
            Thread.sleep(1000);

        }
    }
}