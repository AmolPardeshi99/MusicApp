package com.example.intentservicedownloadfile;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class DownloadIntentService extends IntentService {

    public DownloadIntentService() {
        super("DownloadIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        downloadFile();
    }

    private void downloadFile() {
        try {
            File Directory = new File(getFilesDir() + File.separator + "Vogella");

            if (!Directory.exists()) {
                Directory.mkdir();
            }
            File file = new File(Directory, "vogella.html");
            if (!file.exists()) {
                file.createNewFile();
            }

            URL url = new URL("https://www.vogella.com/index.html");

            InputStream inputStream = url.openConnection().getInputStream();

            InputStreamReader reader = new InputStreamReader(inputStream);
            FileOutputStream writer = new FileOutputStream(file, true);
            int data = reader.read();
            while (data != -1) {
                char ch = (char) data;
                writer.write(ch);
                data = reader.read();
            }
            //Reading File
            FileInputStream fileInputStream = new FileInputStream(file);
            int filedata = fileInputStream.read();
            StringBuffer stringBuffer = new StringBuffer();
            while (filedata != -1) {
                char ch = (char) filedata;
                stringBuffer = stringBuffer.append(ch);  // mutable in nature
                filedata = fileInputStream.read();
            }
            // Setting Broadcast and sending to mainactivity
            Intent intent = new Intent("com.intentService.broadcast");
            intent.putExtra("data",stringBuffer.toString());
            sendBroadcast(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}