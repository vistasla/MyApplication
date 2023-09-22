package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationService extends Service {
    private static final String CHANNEL_ID ="miscellaneous_1" ;
    NotificationChannel channel;
    NotificationCompat.Builder builder;

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
    public NotificationService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        /*try {
            *//*Thread.sleep(5000);*//*
            *//*Thread.currentThread().wait(5000);*//*
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        Toast.makeText(getApplicationContext(),"NotificationService" , Toast.LENGTH_LONG).show();
        createNotificationChannel();
        Intent intent_1 = new Intent(this, DisplayMessageActivity.class);
        intent_1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent_1, PendingIntent.FLAG_IMMUTABLE);
        builder = new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("NotificationTitle");
        builder.setContentText("NotificationContent");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setContentIntent(pendingIntent);
        builder.addAction(R.drawable.bingwallpaper, getString(R.string.notification_action_text), pendingIntent);
        builder.setAutoCancel(true);
        /*builder.setTimeoutAfter(3000);*/
        builder.setFullScreenIntent(pendingIntent, true);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        Notification notification=builder.build();
        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(0, notification);
        Log.d("NotificationService_notify", "completed");

        return  START_STICKY;
    }



}