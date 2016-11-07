package com.marutian.geofence_example;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

/**
 * Copyright 2016 Marutian. All rights reserved.
 *
 * @author Shin Gwangsu (maruroid@gmail.com)
 * @since 2016. 11. 2.
 */
public class GeofenceTransitionsIntentService extends IntentService {

    private static int NOTIFICATION_ID = 0;

    public GeofenceTransitionsIntentService() {
        super("GeofenceIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);

        Log.e("ASDF", "ASDF");
        if(geofencingEvent.hasError()){
            Log.e("GeofenceIntentService", geofencingEvent.getErrorCode()+"");
            return;
        }

        int geofenceTransition = geofencingEvent.getGeofenceTransition();

        if(geofenceTransition == Geofence.GEOFENCE_TRANSITION_ENTER)
            sendNotification("범위 안");
        else if(geofenceTransition == Geofence.GEOFENCE_TRANSITION_EXIT)
            sendNotification("범위 밖");

    }

    private void sendNotification(String notificationDetails) {

        Toast.makeText(getApplicationContext(), notificationDetails, 0).show();
        Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent notificationPendingIntent =  PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification noti = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                        R.mipmap.ic_launcher))
                .setColor(Color.RED)
                .setContentTitle(notificationDetails)
                .setTicker("사용자가 " + notificationDetails + "에 있습니다.")
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)
                .setContentText("설정한 반경 100m" + notificationDetails +"에 있습니다.")
                .setContentIntent(notificationPendingIntent)
                .build();

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(NOTIFICATION_ID++, noti);
    }
}
