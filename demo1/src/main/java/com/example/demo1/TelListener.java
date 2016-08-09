package com.example.demo1;

import android.media.MediaRecorder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import java.io.IOException;

/**
 * Created by Administrator on 2016/7/28.
 */
public class TelListener extends PhoneStateListener {


    @Override
    public void onCallStateChanged(int state, String incomingNumber) {

        MediaRecorder recorder=new MediaRecorder();


        recorder.release();


        switch (state){
            case TelephonyManager.CALL_STATE_IDLE:
                recorder.stop();
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:


                recorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);

                recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                recorder.setOutputFile("mnt/sdcard/test.3gp");
                try {
                    recorder.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                recorder.start();
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                recorder.reset();
                break;
        }

        super.onCallStateChanged(state, incomingNumber);
    }
}
