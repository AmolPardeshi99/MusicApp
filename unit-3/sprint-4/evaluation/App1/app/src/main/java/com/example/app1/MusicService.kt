package com.example.app1

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat


class MusicService : Service() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var url :String
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer()
        showNotificationAndStartForeGround()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
    }

    fun play(){
        mediaPlayer.reset()
        val uri = Uri.parse(url)
        mediaPlayer = MediaPlayer.create(applicationContext,uri)
        mediaPlayer.start()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.run {
            url = intent.getStringExtra("songurl").toString()
        }
        play()
        return super.onStartCommand(intent, flags, startId)

    }

    //    this is about showing the notification
    @RequiresApi(Build.VERSION_CODES.O)
    private fun showNotificationAndStartForeGround() {
        val NOTIFICATION_CHANNEL_ID = "Music Player Running"
        val channelName = "Background Service"
        val chan = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            channelName,
            NotificationManager.IMPORTANCE_NONE
        )
        chan.lightColor = Color.BLUE
        val manager = (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
        manager.createNotificationChannel(chan)
        val notificationBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
        val notification: Notification = notificationBuilder.setOngoing(true)
            .setContentTitle("Music Player App is running in background")
            .setContentText("Hey music is playing")
            .setPriority(NotificationManager.IMPORTANCE_MIN)
            .setCategory(Notification.CATEGORY_SERVICE)
            .build()
        startForeground(2, notification)
    }


}