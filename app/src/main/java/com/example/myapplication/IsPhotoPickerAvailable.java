package com.example.myapplication;

//import android.os.ext.SdkExtensions.getExtensionVersion;
import static android.os.ext.SdkExtensions.getExtensionVersion;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.util.Log;

public class IsPhotoPickerAvailable {
    boolean aBoolean;
    // IsPhotoPickerAvailable(){
public boolean IsPhotoPickerAvailable(){


    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        //aBoolean=true;
        return true;
    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        return getExtensionVersion(Build.VERSION_CODES.R) >= 2;
        //aBoolean=getExtensionVersion(Build.VERSION_CODES.R) >= 2;
    } else{
        return false;
        // aBoolean=false;
}
       // Log.d("IsPhotoPickerAvailable", String.valueOf(aBoolean));

}}

