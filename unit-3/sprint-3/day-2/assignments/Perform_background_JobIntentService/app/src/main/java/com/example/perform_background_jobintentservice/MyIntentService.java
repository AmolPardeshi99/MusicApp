package com.example.perform_background_jobintentservice;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class MyIntentService extends JobIntentService {
    // logt and logd shortcuts
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Thread.currentThread().getName(),"onCreate");
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        if (intent.getStringExtra("JobId").equals("1")){
            for (int i=0; i<=10; i++){
                Log.d(Thread.currentThread().getName(),"JobId1 - "+i);
                SystemClock.sleep(1000);
            }

        }else if (intent.getStringExtra("JobId").equals("2")){

            for (int i=0; i<=12; i++){
                Log.d(Thread.currentThread().getName(),"JobId2 - "+i);
                SystemClock.sleep(1000);
            }
        }
    }

    static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, MyIntentService.class, 9799, work);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(Thread.currentThread().getName(),"onDestroy");
    }
}