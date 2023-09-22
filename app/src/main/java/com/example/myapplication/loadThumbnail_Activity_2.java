package com.example.myapplication;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Size;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class loadThumbnail_Activity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadthumbnail_2);
    }
    public void sendMessage(View view) throws IOException {
        Uri collectionUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver=getApplicationContext().getContentResolver();
        Size size=new Size(30,30);
        try {
            contentResolver.loadThumbnail(collectionUri,size,null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Toast.makeText(getApplicationContext(),"cursor.getCount()"+cursor.getCount() , Toast.LENGTH_LONG).show();
    }
}