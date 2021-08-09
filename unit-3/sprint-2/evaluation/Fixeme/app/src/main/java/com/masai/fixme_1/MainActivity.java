package com.masai.fixme_1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.progressindicator.CircularProgressIndicator;

public class MainActivity extends AppCompatActivity {

    private Button mBtnStartTask;
    private CircularProgressIndicator circularProgressIndicator;

    private Handler mainThreadHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            int progress = (int) msg.obj;
            circularProgressIndicator.setProgress(progress);
            if (progress== 100) {
                Toast.makeText(MainActivity.this,"Your task is completed",Toast.LENGTH_SHORT).show();
                circularProgressIndicator.setVisibility(View.GONE);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        mBtnStartTask= findViewById(R.id.btnStartTask);
        circularProgressIndicator = findViewById(R.id.progress_circular);
        mBtnStartTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Your Task Started please wait",Toast.LENGTH_SHORT).show();
                Task task = new Task("async", mainThreadHandler);
                task.start();
            }
        });
    }
}