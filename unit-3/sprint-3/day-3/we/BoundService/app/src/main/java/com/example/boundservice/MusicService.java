package com.example.boundservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MusicService extends Service {
    public MusicService() {
    }
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public IBinder onBind(Intent intent) {
        return new ServiceBinder();
    }

    public void play(){
        mediaPlayer = MediaPlayer.create(this,R.raw.music);
        if (!mediaPlayer.isPlaying()) mediaPlayer.start();
    }

    public void pause(){
        if (mediaPlayer.isPlaying()) mediaPlayer.pause();
    }

    public void stop(){
        if (mediaPlayer.isPlaying()) mediaPlayer.stop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

    public class ServiceBinder extends Binder {

        public MusicService getMusicService() {
            return MusicService.this;
        }

    }
}