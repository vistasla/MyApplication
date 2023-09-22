package com.example.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class ImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);
    }
    public void sendMessage(View view) throws IOException {

        /*String strImages="/storage/emulated/0/Pictures/IMG_20230314_132447.jpg";
        res/drawable/bingwallpaper.jpg
        */
        //String strImages="bingwallpaper.jpg";
        /*String strImages="drawable/bingwallpaper.jpg";
        Uri uri=Uri.parse(strImages);
        ((ImageView)findViewById(R.id.imageView2)).setImageURI(uri);*/

       Uri uri=Uri.parse("https://cn.bing.com/th?id=OHR.FireFallYosemite_ZH-CN3351604820_1920x1200.jpg&rf=LaDigue_1920x1200.jpg");
        ImageView imageView= (ImageView) findViewById(R.id.imageView2);
       /*Glide.with(getApplicationContext())
                .load(uri)
                .into(imageView);*/
        Glide.with(ImageViewActivity.this)
                .load(uri)
                .into(imageView);
    }
}