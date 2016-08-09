package com.example.sharesevice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnstart,mBtnstop;
    private EditText mEditText;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnstart= (Button) findViewById(R.id.btn_start);
        mBtnstop= (Button) findViewById(R.id.btn_stop);

        mEditText= (EditText) findViewById(R.id.editText);

        mIntent=new Intent(this,MyService.class);

        mBtnstart.setOnClickListener(this);
        mBtnstop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start:
                mIntent.putExtra("data",mEditText.getText().toString());
                startService(mIntent);
                break;
            case R.id.btn_stop:
                stopService(mIntent);
                break;
        }
    }
}
