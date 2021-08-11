package com.example.api_calling_using_service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MyService extends IntentService {


    public MyService() {
        super("name");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        showNotificationAndStartForeGround();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int postId = Integer.parseInt(intent.getStringExtra("userId"));
        callApi(postId);
    }

    private void callApi(int postId) {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.getPost(postId).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                ResponseModel responseModel = response.body();
                String title = responseModel.getTitle();
                Intent intent = new Intent("com.abc.BroadcastSender");
                intent.putExtra("Title",title);
                sendBroadcast(intent);
                Toast.makeText(MyService.this,"Fetch Sucessfully",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(MyService.this,"Fetch failed",Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method for notification
    private void showNotificationAndStartForeGround() {
        createChannel();
        NotificationCompat.Builder notificationBuilder = null;
        notificationBuilder = new NotificationCompat.Builder(this, "CHANNEL_ID")
                .setContentTitle("Service is running ")
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        Notification notification = null;
        notification = notificationBuilder.build();
        startForeground(120, notification);
    }
    public void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("CHANNEL_ID", "CHANNEL_NAME", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Notifications");
            Objects.requireNonNull(this.getSystemService(NotificationManager.class)).createNotificationChannel(channel);
        }
    }
}