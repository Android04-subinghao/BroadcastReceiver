package com.example.administrator.broadcastreceiver;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private MyReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //监控网络的变化
        mReceiver=new MyReceiver();
        //intentFilter对象
        IntentFilter filter=new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(mReceiver,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: start");
        unregisterReceiver(mReceiver);
    }
}
