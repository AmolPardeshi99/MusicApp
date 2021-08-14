package com.example.apmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayMusicActivity extends AppCompatActivity {

    private Button mBtnStart, mBtnPlay, mBtnStop, mBtnPause;
    private String MusicName; private int MusicImageId;
    private TextView mTvMusicname;
    private ImageView mIvMusicImage;
    private MusicService musicService;
    private Boolean isServiceStarted = false;
    private Intent serviceIntent;
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
        setContentView(R.layout.activity_play_music);
        Intent intent = getIntent();
        MusicName = intent.getStringExtra("MusicName");
        MusicImageId = intent.getIntExtra("MusicImage",1);
        initVIew(intent);
        mTvMusicname.setText(MusicName);
        mIvMusicImage.setImageResource(MusicImageId);
    }

    private void initVIew(Intent intent1) {
        mTvMusicname = findViewById(R.id.tvMusicName2);
        mIvMusicImage = findViewById(R.id.ivMusicImage2);
        mBtnStart = findViewById(R.id.btnStartService);
        mBtnStop = findViewById(R.id.btnStopService);
        mBtnPlay = findViewById(R.id.btnPlay);
        mBtnPause = findViewById(R.id.btnPause);

        mBtnStart.setOnClickListener(v -> {
            serviceIntent = new Intent(PlayMusicActivity.this,MusicService.class);
            serviceIntent.putExtra("MusicNameFrom",intent1.getStringExtra("MusicName"));
            bindService(serviceIntent,serviceConnection,BIND_AUTO_CREATE);
            isServiceStarted = true;
        });

        mBtnPlay.setOnClickListener(v -> {
            if (isServiceStarted) musicService.play();
        });

        mBtnPause.setOnClickListener(v -> {
            if (isServiceStarted) musicService.pause();
        });

        mBtnStop.setOnClickListener(v -> {
            stopService(serviceIntent);
            isServiceStarted = false;
        });
    }


}