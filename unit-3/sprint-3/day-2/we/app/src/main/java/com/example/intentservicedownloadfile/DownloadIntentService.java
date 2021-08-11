package com.example.intentservicedownloadfile;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

public class DownloadIntentService extends IntentService {

    public DownloadIntentService() {
        super("DownloadIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {

        }
    }
}