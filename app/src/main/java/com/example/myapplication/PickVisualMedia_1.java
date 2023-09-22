package com.example.myapplication;

import android.util.Log;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

public class PickVisualMedia_1 {
    PickVisualMedia_1(){
        Log.d("PickVisualMedia_1", "start");
        /*ActivityResultLauncher<PickVisualMediaRequest> pickMedia =
                registerForActivityResult(new PickVisualMedia(), uri -> {
                    // Callback is invoked after the user selects a media item or closes the
                    // photo picker.
                    if (uri != null) {
                        Log.d("PhotoPicker", "Selected URI: " + uri);
                    } else {
                        Log.d("PhotoPicker", "No media selected");
                    }
                });

// Include only one of the following calls to launch(), depending on the types
// of media that you want to allow the user to choose from.

// Launch the photo picker and allow the user to choose images and videos.
        pickMedia.launch(new PickVisualMediaRequest.Builder()
                .setMediaType(PickVisualMedia.ImageAndVideo.INSTANCE)
                .build());

// Launch the photo picker and allow the user to choose only images.
        pickMedia.launch(new PickVisualMediaRequest.Builder()
                .setMediaType(PickVisualMedia.ImageOnly.INSTANCE)
                .build());

// Launch the photo picker and allow the user to choose only videos.
        pickMedia.launch(new PickVisualMediaRequest.Builder()
                .setMediaType(PickVisualMedia.VideoOnly.INSTANCE)
                .build());

// Launch the photo picker and allow the user to choose only images/videos of a
// specific MIME type, such as GIFs.
        String mimeType = "image/gif";
        pickMedia.launch(new PickVisualMediaRequest.Builder()
                .setMediaType(new PickVisualMedia.SingleMimeType(mimeType))
                .build());*/

    }
}
