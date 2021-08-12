package com.example.perform_background_jobintentservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mBtnJob1, mBtnJob2;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnJob1 = findViewById(R.id.btnJobId1);
        mBtnJob2 = findViewById(R.id.btnJobId2);
        intent = new Intent(MainActivity.this,MyIntentService.class);

        mBtnJob1.setOnClickListener(v -> {
            intent.putExtra("JobId","1");
            MyIntentService.enqueueWork(this,intent);
        });

        mBtnJob2.setOnClickListener(v -> {
            intent.putExtra("JobId","2");
            MyIntentService.enqueueWork(this,intent);
        });
    }


}