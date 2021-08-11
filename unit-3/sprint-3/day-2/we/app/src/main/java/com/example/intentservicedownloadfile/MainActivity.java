package com.example.intentservicedownloadfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mBtnDownloadFile;
    private TextView mtvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        IntentFilter intentFilter = new IntentFilter("com.intentService.broadcast");
        registerReceiver(receiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    private void initView() {
        Intent intent = new Intent(this, DownloadIntentService.class);
        mBtnDownloadFile = findViewById(R.id.btnDownload);
        mtvData = findViewById(R.id.tvData);
        mBtnDownloadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
           String data =  intent.getStringExtra("data");
           mtvData.setText(data);
        }
    };
}