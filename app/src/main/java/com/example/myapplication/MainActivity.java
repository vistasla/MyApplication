package com.example.myapplication;

import static android.app.PendingIntent.FLAG_MUTABLE;
import static android.app.PendingIntent.getActivity;
import static android.app.PendingIntent.getService;
import static android.content.Intent.EXTRA_ALLOW_MULTIPLE;

import static com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.FirstPoint.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("savedInstanceState", String.valueOf(savedInstanceState==null));
    }
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart");
    }
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume");
    }
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause");
    }
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "onRestart");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }

    /** Called when the user taps the Send button */
    @SuppressLint("IntentReset")
    public void sendMessage(View view) throws IOException, PendingIntent.CanceledException {

        /*Intent intent=new Intent(this, ForegroundService.class);
        startService(intent);*/

        /*Context context = getApplicationContext();
        Intent intent = new Intent(this, ForegroundService.class); // Build the intent for the service
        context.startForegroundService(intent);*/

        /*Intent intent=new Intent(this, MainActivity2.class);
        //Intent intent=new Intent(this, ImageViewActivity.class);
        startActivity(intent);*/

        /*Intent intent=new Intent(this, InteractingWithOtherApps.class);
        startActivity(intent);*/
        /*Intent intent=new Intent(this, MyWebViewActivity.class);
        startActivity(intent);*/

        //Intent intent=new Intent(this, ConstraintLayoutActivity.class);
        /*Intent intent=new Intent(this, AccessLocationActivity_1.class);
        startActivity(intent);*/
        /*Intent intent=new Intent(this, CreateAlarmActivity_1.class);
        startActivity(intent);*/
        Intent intent=new Intent(this, BDLocationActivity.class);
        startActivity(intent);
        /*Intent intent=new Intent(this, ImplementOrderActivity.class);
        startActivity(intent);*/


        /*Intent intent=new Intent(this, WeatherActivity.class);
        startActivity(intent);*/
        /*Intent intent=new Intent(this, MediaStore_Images_query_Service_1.class);
        startService(intent);*/

        /*false*/
        /*Intent intent=new Intent();
        //intent.setClassName("com.example.myapplication_1","MainActivity1.class");
        //ComponentName componentName=new ComponentName("com.example.myapplication_1","MainActivity1.class");
        //ComponentName componentName=new ComponentName(getApplicationContext(),"MainActivity1.class");
        ComponentName componentName=new ComponentName(getApplicationContext(),MainActivity1.class);
        intent.setComponent(componentName);
        startActivity(intent);*/

        /*Intent intent=new Intent(this, progressBar.class);
        startActivity(intent);*/

        /*Intent intent=new Intent();
        intent.setAction("com.example.broadcast.MY_NOTIFICATION");
        intent.setPackage("com.example.myapplication_1");
        //sendOrderedBroadcast(intent, null );
        sendBroadcast(intent);*/

        /*false*/
        /*Log.d("ApplicationContext", intent.getPackage());*/

        //addEvent("myEvent","mylocation",0,1);
        // dispatchTakePictureIntent();
        //capturePhoto( "targetFilename");
        //CreateAlarm_Service createAlarm_service=new CreateAlarm_Service("myAlarm_1",12,12);
        //capturePhoto();
        //startTimer( "title_1",  60);
        //ShowAllAlarms();
        //capturePhoto();
        //selectContact();
        //selectContact();
        //insertContact("vistasla_1","1234567" ,"vistasla@163.com");
        //String[] addresses=new String["vistasla@163.com","vistasla_1@163.com","vistasla_2@163.com"];
        /*String[] addresses=new String[3];
        addresses[0]="vistasla@163.com";
        addresses[1]="vistasla_1@163.com";
        addresses[2]="vistasla_2@163.com";

        Uri uri=MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL);
        //composeEmail( addresses,  "subject", uri);
        composeEmail( addresses,  "subject");*/
        //selectImage();
        //MainActivity2 mainActivity2=new MainActivity2();
        //callCar();
        /*Uri geoLocation=Uri.parse("geo:47.6,-122.3");
        showMap(geoLocation);*/
       // Uri Mediauri=Uri.parse("/storage/emulated/0/Pictures/music.mp3");
        /*Uri Mediauri=Uri.parse("/storage/emulated/0/Pictures/video.mp4");
        //String strImages="/storage/emulated/0/Pictures";
        playMedia(Mediauri);*/
        //createNote("subject",  "text");
        //playSearchArtist( "artist");
        //dialPhoneNumber("2125551212");
        //dialPhoneNumber("5551212");
        //search( "query");
        //searchWeb("query");
        //openWifiSettings();
        /*Uri Mediauri=Uri.parse("/storage/emulated/0/Pictures/music.mp3");*/
        //Uri Mediauri=Uri.parse("/storage/emulated/0/Pictures/video.mp4");
        /*Uri Mediauri=Uri.parse("/storage/emulated/0/Pictures/image.png");

        composeMmsMessage( "message", Mediauri);*/
       /* Uri Mediauri=Uri.parse("https://developer.android.google.cn/guide/components/intents-common?hl=zh-cn");
        openWebPage("https://developer.android.google.cn/guide/components/intents-common?hl=zh-cn");*/
    }
    @SuppressLint("MissingPermission")
    void AccessLocationActivity() {
        FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(getApplicationContext());



        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, location -> {
                    if (location != null) {
                        // Logic to handle location object.
                        Log.d("AccessLocationActivity:", String.valueOf(location));
                    }
                });



    }
    /*public void addEvent(String title, String location, long begin, long end) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
        startActivity(intent);

       *//* if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else{

            Log.d("IsaddEventAvailable", "false");

        }*//*
    }*/
    static final int REQUEST_IMAGE_CAPTURE = 1;

   /* private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }*/
    /*private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }*/
    /*static final int REQUEST_IMAGE_CAPTURE = 1;
    //static final Uri locationForPhotos ;
    Uri locationForPhotos=MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL);

    public void capturePhoto(String targetFilename) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                Uri.withAppendedPath(locationForPhotos, targetFilename));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap thumbnail = data.getParcelableExtra("data");
            // Do other work with full size photo saved in locationForPhotos

        }
    }*/

    /*public void capturePhoto() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
        *//*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }*//*
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);

    }*/
    /*public void startTimer(String message, int seconds) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, false);
        *//*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*//*
        startActivity(intent);
    }*/
    /*public void ShowAllAlarms() {
        Intent intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS)
                ;
        *//*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*//*
        startActivity(intent);
    }*/

    /*public void capturePhoto() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
       *//* if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }*//*
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }*/
    static final int REQUEST_SELECT_CONTACT = 1;

    /*public void selectContact() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        *//*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_CONTACT);
        }*//*
        startActivityForResult(intent, REQUEST_SELECT_CONTACT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SELECT_CONTACT && resultCode == RESULT_OK) {

            Uri contactUri = data.getData();
            contactUri = data.getData();
            //viewContact(contactUri);
            editContact( contactUri, "vistasla@email.com");
            Log.d("contactUri", String.valueOf(contactUri));

            // Do something with the selected contact at contactUri

        }
    }*/
    static final int REQUEST_SELECT_PHONE_NUMBER = 1;

    /*public void selectContact() {
        // Start an activity for the user to pick a phone number from contacts
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        //intent.setType(ContactsContract.CommonDataKinds.Email.TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_PHONE_NUMBER);
        }
        startActivityForResult(intent, REQUEST_SELECT_PHONE_NUMBER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SELECT_PHONE_NUMBER && resultCode == RESULT_OK) {
            // Get the URI and query the content provider for the phone number
            Uri contactUri = data.getData();
            Log.d("contactUri", String.valueOf(contactUri));
            //viewContact( contactUri);
             editContact( contactUri, "vistasla@email.com");
            *//*String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};
            //String[] projection = new String[]{ContactsContract.CommonDataKinds.Email.ADDRESS};
            Cursor cursor = getContentResolver().query(contactUri, projection,
                    null, null, null);
            // If the cursor returned is valid, get the phone number
            if (cursor != null && cursor.moveToFirst()) {
                int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                //int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS);
                String number = cursor.getString(numberIndex);
                Log.d("number",number );
                // Do something with the phone number
                //...
            }*//*
        }
    }*/
   /*public void viewContact(Uri contactUri) {
       Intent intent = new Intent(Intent.ACTION_VIEW, contactUri);
       *//*if (intent.resolveActivity(getPackageManager()) != null) {
           startActivity(intent);
       }*//*
       startActivity(intent);
   }*/
    /*public void editContact(Uri contactUri, String email) {
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setData(contactUri);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }*/
    /*public void insertContact(String name, String phone,String email) {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
        *//*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*//*
        startActivity(intent);
    }*/

    public void composeEmail_0(String[] addresses, String subject, Uri attachment) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_STREAM, attachment);
        intent.putExtra(Intent.EXTRA_TEXT, "text");
        /*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*/
        startActivity(intent);
    }

    /*public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, "text");
        *//*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*//*
        startActivity(intent);
    }*/

    static final int REQUEST_IMAGE_GET = 1;

  public void selectImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        //intent.setType("video/*");
        intent.putExtra(EXTRA_ALLOW_MULTIPLE,true);
       /*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_GET);
        }*/
        startActivityForResult(intent, REQUEST_IMAGE_GET);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK) {
            Bitmap thumbnail = data.getParcelableExtra("data");
            //Bitmap thumbnail = data.getParcelable("data");

            /*Canvas canvas=new Canvas();
            Paint paint=new Paint();
            Color color=new Color();
            paint.setColor(0);
            canvas.drawBitmap(thumbnail,0,0,paint);*/

            ImageView imageView= this.findViewById(R.id.imageView);
            Uri fullPhotoUri = data.getData();
            //imageView.setImageResource();
            //imageView.setImageURI(fullPhotoUri);
            Drawable drawable=imageView.getDrawable();
            TextView textView=this.findViewById(R.id.textView);
            //textView.setText(drawable.getAlpha());

            //Log.d(" textView", (String) textView.getText());
            //Log.d(" Drawable", String.valueOf(drawable.isProjected()));
            //Log.d(" Drawable", String.valueOf(drawable.getMinimumHeight()));
            //imageView.draw(canvas);

            Log.d("fullPhotoUri ", String.valueOf(fullPhotoUri));
            // Do work with photo saved at fullPhotoUri

        }
    }
    static final int REQUEST_IMAGE_OPEN = 1;

    /*public void selectImage() {
        //Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        //intent.setType("application/xml");
        //intent.setType("text/plain");
        intent.setType("text/css");
        intent.putExtra(EXTRA_ALLOW_MULTIPLE,true);
        intent.putExtra(EXTRA_TITLE,"myfile");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        // Only the system receives the ACTION_OPEN_DOCUMENT, so no need to test.
        startActivityForResult(intent, REQUEST_IMAGE_OPEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_OPEN && resultCode == RESULT_OK) {
            Uri fullPhotoUri = data.getData();
            *//*ClipData clipData=data.getClipData();

            Uri fullPhotoUri = clipData.getItemAt(0).getUri();*//*
            Log.d("fullPhotoUri ", String.valueOf(fullPhotoUri));

            // Do work with full size photo saved at fullPhotoUri

        }*/
    /*public void callCar() {
        Intent intent = new Intent(ReserveIntents.ACTION_RESERVE_TAXI_RESERVATION);
        *//*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*//*
        startActivity(intent);
    }*/
    /*public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        *//*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*//*
        startActivity(intent);
    }*/
    /*public void playMedia(Uri file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(file);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        startActivity(intent);
    }*/
    /*public void playSearchArtist(String artist) {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
        intent.putExtra(MediaStore.EXTRA_MEDIA_FOCUS,
                MediaStore.Audio.Artists.ENTRY_CONTENT_TYPE);
        intent.putExtra(MediaStore.EXTRA_MEDIA_ARTIST, artist);
        intent.putExtra(SearchManager.QUERY, artist);
        *//*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*//*
        startActivity(intent);
    }
*/
    /*public void createNote(String subject, String text) {
        Intent intent = new Intent(NoteIntents.ACTION_CREATE_NOTE)
                .putExtra(NoteIntents.EXTRA_NAME, subject)
                .putExtra(NoteIntents.EXTRA_TEXT, text);
        *//*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*//*
        startActivity(intent);
    }*/
    /*public void dialPhoneNumber(String phoneNumber) {
        *//*Intent intent = new Intent(Intent.ACTION_DIAL);*//*
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        *//*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*//*
        startActivity(intent);
    }*/
    /*public void search(String query) {
        Intent intent = new Intent("com.google.android.gms.actions.SEARCH_ACTION");
        intent.putExtra(SearchManager.QUERY, query);
        *//*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*//*
        startActivity(intent);
    }*/

    /*public void searchWeb(String query) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        *//*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*//*
        startActivity(intent);
    }*/
    /*public void openWifiSettings() {
        *//*Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);*//*
        *//*Intent intent = new Intent(ACTION_SETTINGS);*//*
        Intent intent = new Intent(ACTION_BLUETOOTH_SETTINGS);
        *//*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*//*
        startActivity(intent);
    }*/
   /* public void composeMmsMessage(String message, Uri attachment) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        //intent.setType("video/*");
        intent.setType("image/*");
        intent.putExtra("sms_body", message);
        intent.putExtra(Intent.EXTRA_STREAM, attachment);
        *//*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*//*
        startActivity(intent);
    }*/
    /*public void composeMmsMessage(String message, Uri attachment) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("smsto:12345678"));  // This ensures only SMS apps respond
        intent.setType("text/plain");

        intent.putExtra("sms_body", message);
        intent.putExtra(Intent.EXTRA_STREAM, attachment);
        *//*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*//*
        startActivity(intent);
    }*/
    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        /*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*/
        startActivity(intent);
    }




}



