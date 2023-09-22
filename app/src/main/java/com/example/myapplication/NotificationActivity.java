package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.io.IOException;

public class NotificationActivity extends AppCompatActivity {
    private static final String CHANNEL_ID ="miscellaneous_1" ;
    NotificationChannel channel;
    NotificationCompat.Builder builder;
    NotificationManagerCompat notificationManager;
    Notification notification;
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            Log.d("createNotificationChannel", "completed");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        createNotificationChannel();
    }
    protected void onStart() {
        super.onStart();


    }
    public void sendMessage(View view) throws IOException {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
       /* Intent snoozeIntent = new Intent(this, MyReceiver.class);
        snoozeIntent.setAction("ACTION_SNOOZE");
        snoozeIntent.putExtra(EXTRA_NOTIFICATION_ID, 0);*/

        Toast.makeText(getApplicationContext(),"NotificationActivity_bejin_notify" , Toast.LENGTH_LONG).show();

        builder = new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("NotificationTitle");
        builder.setContentText("NotificationContent");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        /*builder.setCategory(NotificationCompat.CATEGORY_CALL);*/
        builder.addAction(R.drawable.bingwallpaper, getString(R.string.notification_action_text), pendingIntent);

        /*int PROGRESS_MAX = 100;
        int PROGRESS_CURRENT = 50;
        builder.setProgress(PROGRESS_MAX, PROGRESS_CURRENT, false);
        builder.setProgress(0, 0, true);*/

        notification=builder.build();



        /*NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);*/
         notificationManager = NotificationManagerCompat.from(this);
        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(0,notification);

        /*RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY);*/
    }
    public void sendMessage_1(View view) throws IOException {

        /*//如果发出相同的通知,更换id即可.
        notificationManager.notify(1, notification);*/

        /*//重构notification实现通知的复用
        builder.setContentTitle("NotificationTitle_1");
        builder.setContentText("NotificationContent");
        notification=builder.build();
        notificationManager.notify(1, notification);*/

/*//相同的id更新通知内容.
        builder.setContentTitle("NotificationTitle_1");
        builder.setContentText("NotificationContent");
        notification=builder.build();
        notificationManager.notify(0, notification);*/
    }
    public void sendMessage_2(View view) throws IOException {
        notificationManager.cancelAll();
    }
}
/*
channel.getConversationId()*/
