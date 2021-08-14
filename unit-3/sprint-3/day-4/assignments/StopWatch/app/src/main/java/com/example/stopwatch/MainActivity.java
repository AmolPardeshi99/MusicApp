package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private Chronometer stopWatch;
    private boolean isRunning;
    private long PauseMemory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        stopWatch.setFormat("%s");
        stopWatch.setBase(SystemClock.elapsedRealtime());
//        stopWatch.setOnChronometerTickListener(chronometer -> {
//            if ()
//        });
    }

    private void initview() {
        stopWatch = findViewById(R.id.StopWatch);
    }

    public void startStopWatch(View view){
        if (!isRunning) {
            stopWatch.setBase(SystemClock.elapsedRealtime()-PauseMemory);
            stopWatch.start();
            isRunning = true;
        }

    }
    public void PauseStopWatch(View view){
        if (isRunning) {
            stopWatch.stop();
            PauseMemory = SystemClock.elapsedRealtime() - stopWatch.getBase();
            isRunning = false;
        }
    }
    public void ResetStopWatch(View view){
        stopWatch.setBase(SystemClock.elapsedRealtime());
        PauseMemory =0;

    }
}