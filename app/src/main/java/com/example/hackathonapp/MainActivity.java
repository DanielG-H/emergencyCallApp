package com.example.hackathonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        TextView viewEnterText = findViewById(R.id.etEnterText);
        String text = viewEnterText.getText().toString();

        TextView showViewText = findViewById(R.id.textView2);
        showViewText.setText(text);
    }
}