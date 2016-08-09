package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Runnable{
    Button mButton;
    long count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton= (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendBroadcast(new Intent("com.example.test.MY_BROADCAST"));
            }
        });
        fibonacci(10000);
        new Thread(this).start();
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1500);
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public long fibonacci(long number) {
        for (count=0;count<10000;count++) {
            if ((number == 0) || (number == 1)) {
                return number;
            }
            else {
                return fibonacci(number - 1) + fibonacci(number - 2);
            }
        }
        return count;
    }
}
