package com.marutian.geofence_example;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Copyright 2016 Marutian. All rights reserved.
 *
 * @author Shin Gwangsu (maruroid@gmail.com)
 * @since 2016. 11. 2.
 */
public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED")){
            ComponentName cName = new ComponentName(context.getPackageName(), GeofenceService.class.getName());
            ComponentName svcName = context.startService(new Intent().setComponent(cName));

            if(svcName == null)
                Log.e("BootCompleteReceiver", "Could not start service " + cName.toString());
        }
    }
}
