package com.example.demo1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/7/26.
 */
public class MyBroadcastReceiver extends BroadcastReceiver{

    public static final String ACTION="com.example.broadcasttest.MY_BROADCAST";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION.equals(intent.getAction())){
            Toast.makeText(context,"收到信息",Toast.LENGTH_SHORT).show();
        }

    }
}
