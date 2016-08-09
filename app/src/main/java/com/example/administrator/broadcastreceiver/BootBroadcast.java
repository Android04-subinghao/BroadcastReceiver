package com.example.administrator.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/7/26.
 */
public class BootBroadcast extends BroadcastReceiver{
    public static final String ACTION_BOOT="android.intent.action.BOOT_COMPLETED";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION_BOOT.equals(intent.getAction())){
            Toast.makeText(context,"开机完毕",Toast.LENGTH_SHORT).show();
        }
    }
}
