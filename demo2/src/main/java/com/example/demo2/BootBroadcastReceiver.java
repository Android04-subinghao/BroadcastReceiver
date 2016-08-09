package com.example.demo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2016/7/28.
 */
public class BootBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "PhoneListener";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "boot completed received");
        Intent service = new Intent(context, PhoneListenService.class);
        context.startService(service);
    }
}
