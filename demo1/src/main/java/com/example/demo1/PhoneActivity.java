package com.example.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PhoneActivity extends AppCompatActivity implements View.OnClickListener {
    Button mbtnstart,mbtnstop,mbtnreset;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        mbtnstart= (Button) findViewById(R.id.btn_start);
        mbtnstop= (Button) findViewById(R.id.btn_stop);
        mbtnreset= (Button) findViewById(R.id.btn_reset);

        mbtnstart.setOnClickListener(this);
        mbtnstop.setOnClickListener(this);
        mbtnreset.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start:
                intent=new Intent(this,PhoneService.class);
                startService(intent);
                break;
            case R.id.btn_stop:
                stopService(intent);
                break;
            case R.id.btn_reset:
                break;
        }
    }
}
