package com.example.boundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mBtnPause, mBtnPlay, mBtnStop;
    private MusicService musicService;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicService.ServiceBinder serviceBinder = (MusicService.ServiceBinder) service;
            musicService = serviceBinder.getMusicService();
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

        Intent intent = new Intent(this, MusicService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    private void initView() {
        mBtnPause = findViewById(R.id.btnPause);
        mBtnPlay = findViewById(R.id.btnPlay);
        mBtnStop = findViewById(R.id.btnStop);

        mBtnPlay.setOnClickListener(v -> {
            musicService.play();
        });

        mBtnStop.setOnClickListener(v -> {
            musicService.stop();
        });

        mBtnPause.setOnClickListener(v -> {
            musicService.pause();
        });
    }

}