package com.example.myapplication;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void sendMessage(View view) throws IOException {

        //Uri collectionUri =Uri.parse("/storage/emulated/0/Pictures/IMG_20230321_142322.jpg");
        //Uri collectionUri =Uri.parse("content://MediaStore/Images/IMG_20230321_142322.jpg");
        //Uri collectionUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Uri collectionUri=Uri.parse("https://cn.bing.com/th?id=OHR.FireFallYosemite_ZH-CN3351604820_1920x1200.jpg&rf=LaDigue_1920x1200.jpg");
        ContentResolver contentResolver=getApplicationContext().getContentResolver();
        Size size=new Size(30,30);
        try {
            ImageView imageView= (ImageView) findViewById(R.id.imageView5);
            Bitmap bitmap=contentResolver.loadThumbnail(collectionUri,size,null);
            Log.d("bitmap.getByteCount()", String.valueOf(bitmap.getByteCount()));
            Toast.makeText(getApplicationContext(),"bitmap.getByteCount()"+ bitmap.getByteCount(), Toast.LENGTH_LONG).show();
            //imageView.setImageBitmap(bitmap);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Toast.makeText(getApplicationContext(),"cursor.getCount()"+cursor.getCount() , Toast.LENGTH_LONG).show();
    }
}