package com.example.hackathonapp;

import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class HomescreenActivity extends AppCompatActivity {
    private ArrayList<Integer> hrValues = new ArrayList();
    private String TAG = "HomescreenActivity";
    private BroadcastReceiver updateReceiver;
    private TextView tvAvgHeartRate;
    private TextView tvShowStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        tvAvgHeartRate = (TextView)findViewById(R.id.tv_show_avg_heart_rate);
        tvShowStatus = (TextView)findViewById(R.id.tv_show_signals_status);
        insertValues();
        showValues();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateValues();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(updateReceiver);
    }

    public void updateValues() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        updateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                showValues();
            }
        };
        registerReceiver(updateReceiver, intentFilter);
    }

    public void insertValues() {
        Random r = new Random();
        for (int i = 0; i < 30; i++) {
            int number = r.nextInt(140 - 60) + 60;;
            hrValues.add(number);
        }
    }

    public void showValues() {
        int data;
        for (int i = 0; i < hrValues.size(); i++) {
            data = hrValues.get(i);
            tvAvgHeartRate.setText(String.valueOf(data));
            tvShowStatus.setText(decideStatus(data));
            Log.i(TAG, String.valueOf(data));
        }
    }

    private String decideStatus(int value) {
        String status;
        if (value >= 60 && value < 100) {
            status = "Stable";
        } else if (value >= 100 && value < 120) {
            status = "Severe";
        } else {
            status = "Critical";
        }
        return status;
    }
}