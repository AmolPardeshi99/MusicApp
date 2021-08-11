package com.example.api_calling_using_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBtnFetchData;
    private EditText mEtUserId;
    private TextView mTvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        IntentFilter intentFilter = new IntentFilter("com.abc.BroadcastSender");
        registerReceiver(receiver,intentFilter);
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            mTvTitle.setText(intent.getStringExtra("Title"));
        }
    };

    private void initView() {
        mBtnFetchData = findViewById(R.id.btnFetchData);
        mEtUserId = findViewById(R.id.etId);
        mTvTitle = findViewById(R.id.tvTitle);
        mBtnFetchData.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,MyService.class);
            intent.putExtra("userId",mEtUserId.getText().toString());
            startService(intent);
        });


    }


}