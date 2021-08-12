package com.example.getnamefromservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mBtnStartService, mBtnStopService, mBtnGetName;
    private TextView mTvName;
    private Intent intent;
    private Boolean ServiceStarted = false;
    private GetNameService getNameService;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            GetNameService.ServiceBinder serviceBinder = (GetNameService.ServiceBinder) service;
            getNameService = serviceBinder.getNameService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnGetName = findViewById(R.id.btnGetName);
        mBtnStartService = findViewById(R.id.btnStartService);
        mBtnStopService = findViewById(R.id.btnStopService);
        mTvName = findViewById(R.id.tvMyName);
        mBtnStartService.setOnClickListener(v -> {
            intent = new Intent(this,GetNameService.class);
            bindService(intent,serviceConnection,BIND_AUTO_CREATE);
            ServiceStarted = true;
        });

        mBtnGetName.setOnClickListener(v -> {
            if (ServiceStarted) {
                mTvName.setText(getNameService.getName());
            }
        });

        mBtnStopService.setOnClickListener(v -> {
            mTvName.setText("Here text will be shown");
            stopService(intent);
            ServiceStarted = false;
        });
    }
}