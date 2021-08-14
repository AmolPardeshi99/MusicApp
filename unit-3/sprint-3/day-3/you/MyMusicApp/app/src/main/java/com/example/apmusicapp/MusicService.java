package com.example.apmusicapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;
    public MusicService() {
    }

    public void play(){

        if (!mediaPlayer.isPlaying()) mediaPlayer.start();
    }
    public void pause(){
        if (mediaPlayer.isPlaying()) mediaPlayer.pause();
    }

    @Override
    public IBinder onBind(Intent intent) {
        if (!(intent.getStringExtra("MusicNameFrom") == null)){
        switch (intent.getStringExtra("MusicNameFrom")){
            case "Bandeya re Bandeya": mediaPlayer = MediaPlayer.create(this,R.raw.bandeya_re);
                break;
            case "Bharat Ki Beti": mediaPlayer = MediaPlayer.create(this,R.raw.bharat_ki_beti);
                break;
            case "Challa - URI": mediaPlayer = MediaPlayer.create(this,R.raw.challa_uri);
                break;
            case "Dhaga Aspirants": mediaPlayer = MediaPlayer.create(this,R.raw.dhaga_aspirants);
                break;
            case "Give me Some Sunshine": mediaPlayer = MediaPlayer.create(this,R.raw.giveme_some_sunshine);
                break;
            case "Liggi - Ritviz": mediaPlayer = MediaPlayer.create(this,R.raw.liggi_ritviz);
                break;
            case "Manzar hai Naya": mediaPlayer = MediaPlayer.create(this,R.raw.manzar_hai_naya);
                break;
            case "Nazm Nazm sa": mediaPlayer = MediaPlayer.create(this,R.raw.nazm_nazm);
                break;
            case "Shabashiyan - Mission Mangal": mediaPlayer = MediaPlayer.create(this,R.raw.shabashiyan);
                break;
            case "Teri Mitti - Kesari": mediaPlayer = MediaPlayer.create(this,R.raw.teri_mitti_kesari);
        }}
        return new ServiceBinder();
    }

    public class ServiceBinder extends Binder{

        public MusicService getMusicService(){
            return MusicService.this;
        }
    }

}