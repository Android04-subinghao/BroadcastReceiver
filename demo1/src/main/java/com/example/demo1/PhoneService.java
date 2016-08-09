package com.example.demo1;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import java.io.IOException;

/**
 * Created by Administrator on 2016/7/28.
 */
public class PhoneService extends Service {

    MediaRecorder recorder;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        TelephonyManager telManager = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
        telManager.listen(new phoneListener(), PhoneStateListener.LISTEN_CALL_STATE);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private class phoneListener extends PhoneStateListener{
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            switch (state){
                case TelephonyManager.CALL_STATE_IDLE:
                    recorder.stop();
                    recorder.release();
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    recorder=new MediaRecorder();
                    recorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);

                    recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                    recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                    recorder.setOutputFile("mnt/sdcard/test.3gp");
                    try {
                        recorder.prepare();
                        recorder.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                    recorder.reset();
                    break;
            }
            super.onCallStateChanged(state, incomingNumber);
        }
    }

}
