package com.example.demo1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by Administrator on 2016/7/26.
 */
public class MassageReceiver extends BroadcastReceiver {

    private final String action = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(action)) {

            abortBroadcast();

            //用来存放结果的字符串
            StringBuilder sb = new StringBuilder();

            //取出信息内容的载体
            Bundle bundle = intent.getExtras();

            //如果内容不为空
            if (bundle != null) {

                //得到信息内容 是一段一段的
                Object[] pdus = (Object[]) bundle.get("pdus");

                //短信对象数组
                SmsMessage[] messages = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }

                //循环遍历短信数组 取出内容
                for (int i = 0; i < messages.length; i++) {

                    if (i == 0) {
                        sb.append("发件人:" + messages[i].getDisplayOriginatingAddress()
                                + "\n信息内容为:\n");
                    }
                    sb.append(messages[i].getDisplayMessageBody() + "\n");
                }

                Log.e("---sss---", sb.toString());

            }

        }
    }
}
