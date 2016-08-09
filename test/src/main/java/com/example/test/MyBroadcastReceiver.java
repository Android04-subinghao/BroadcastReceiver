package com.example.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/7/26.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "MyBroadcastReceiver";
    public static final String ACTION="com.example.test.MY_BROADCAST";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION.equals(intent.getAction())){
            Toast.makeText(context,"开始计算",Toast.LENGTH_SHORT).show();
        }
    }
}
