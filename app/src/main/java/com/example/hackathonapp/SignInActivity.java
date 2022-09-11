package com.example.hackathonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SignInActivity extends AppCompatActivity {
    ArrayList<String> listOfAccounts = new ArrayList();
    private static final String TAG = "SignInActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        createAccount();
        obtainEmailAccountAndPassword();
    }

    public void obtainEmailAccountAndPassword() {
        Button signInBtn = findViewById(R.id.btn_sign_in);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TextView tvGetEmail = findViewById(R.id.et_email_address);
                TextView tvGetPassword = findViewById(R.id.et_account_password);
                String email = tvGetEmail.getText().toString();
                String password = tvGetPassword.getText().toString();
                Log.d(TAG, "clicked sign in");
            }
        });
    }

    public void createAccount() {
        findViewById(R.id.tv_sign_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
                Log.d(TAG, "clicked create account");
            }
        });
    }

    public void validateAccount() {

    }
}