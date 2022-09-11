package com.example.hackathonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_tap_to_start_app).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SignInActivity.class));
                Log.d("", "tapped start app");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedpreferences = getSharedPreferences(getString(R.string.Nursik_name), Context.MODE_PRIVATE);
        if (!sharedpreferences.getBoolean(getString(R.string.nursik_main_title), false)) {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(getString(R.string.nursik_main_title), Boolean.TRUE);
            editor.apply();
        } else {
            startActivity(new Intent(getApplicationContext(), HomescreenActivity.class));
        }
    }
}