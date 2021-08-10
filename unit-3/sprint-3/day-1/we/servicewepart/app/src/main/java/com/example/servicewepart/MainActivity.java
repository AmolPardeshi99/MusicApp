package com.example.servicewepart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEtText;
    private Button mBtnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        IntentFilter intentFilter = new IntentFilter("com.abc.service");
        registerReceiver(serviceReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(serviceReceiver);
    }

    private void initView() {
        mEtText = findViewById(R.id.etEditText);
        mBtnButton = findViewById(R.id.btnButton);
        mBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FileOperationService.class);
                intent.putExtra("name",mEtText.getText().toString());
                startService(intent);
            }
        });
    }

    private BroadcastReceiver serviceReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,intent.getStringExtra("data"),Toast.LENGTH_SHORT).show();
        }
    };
}