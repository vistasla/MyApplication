package com.example.myapplication;

import android.content.Intent;
import android.provider.MediaStore;
import android.util.Log;

public class MyPhotopicker {

    public MyPhotopicker() {

        IsPhotoPickerAvailable isPhotoPickerAvailable = new IsPhotoPickerAvailable();
        if (isPhotoPickerAvailable.IsPhotoPickerAvailable()) {

            //String strImages="/storage/emulated/0/Pictures";
            //new TakePicture();
            //PickVisualMedia pickVisualMedia=new PickVisualMedia();
            /*Intent intent=new Intent(this,PickVisualMedia_2.class);*/
            //intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            //intent.setAction(Intent.ACTION_PICK);
            /*intent.setAction(MediaStore.ACTION_PICK_IMAGES);*/

        } else {
            Log.d("IsPhotoPickerAvailable", "false");
        }
    }
}