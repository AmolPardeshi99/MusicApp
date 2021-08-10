package com.example.servicewepart;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class FileOperationService extends Service {

    private String name= "";
    public FileOperationService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        showNotificationAndStartForeGround();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent!= null){
            name = intent.getStringExtra("name");
        }
        launchThread();
        return super.onStartCommand(intent, flags, startId);
    }

    private void launchThread() {
        Thread thread = new Thread(task);
        thread.start();
    }

    private Runnable task = new Runnable() {
        @Override
        public void run() {
            saveToFile();
        }
    };

    private void saveToFile() {
        // saving details to file
        try {
            // create directory 1.Internal Storage  2. External Storage 3. External SD card
            File file = new File(getFilesDir() + File.separator + "NameFolder");

            if (!file.exists()) {
                file.mkdir();
            }
            // create file inside directory

            File file1 = new File(file, "name.txt");
            if (!file1.exists()) {
                file1.createNewFile();
            }

            FileOutputStream fileOutputStream = new FileOutputStream(file1, true);
            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
            writer.append(name+"\n");
            writer.close();

            Intent intent = new Intent("com.abc.service");
            intent.putExtra("data","write done");
            sendBroadcast(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

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



    /*
Create noticiation channel if OS version is greater than or eqaul to Oreo
*/
    public void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("CHANNEL_ID", "CHANNEL_NAME", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Notifications");
            Objects.requireNonNull(this.getSystemService(NotificationManager.class)).createNotificationChannel(channel);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}