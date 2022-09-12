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
    ArrayList<Account> listOfAccounts = new ArrayList<Account>(5);
    ArrayList<String> emails = new ArrayList<String>(5);
    ArrayList<String> passwords = new ArrayList<String>(5);
    private static final String TAG = "SignInActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signUp();
        obtainEmailAccountAndPassword();

        emails.add("john@m.com");
        emails.add("jane@m.com");
        emails.add("kent@m.com");
        emails.add("martha@m.com");
        emails.add("jimmy@m.com");

        passwords.add("1234");
        passwords.add("1111");
        passwords.add("makomori");
        passwords.add("hello");
        passwords.add("z");

        for (int i = 0; i < listOfAccounts.size(); i++) {
            Account acc = new Account();
            listOfAccounts.add(acc);
            acc.setEmail(emails.get(i));
            acc.setPassword(passwords.get(i));

        }
    }

    public void obtainEmailAccountAndPassword() {
        Button signInBtn = findViewById(R.id.btn_sign_in);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TextView tvGetEmail = findViewById(R.id.et_email_address);
                TextView tvGetPassword = findViewById(R.id.et_account_password);
                String email = tvGetEmail.getText().toString();
                String password = tvGetPassword.getText().toString();
                Log.i(TAG, "clicked sign in");
                // TODO: app validation
//                boolean validate =  isAccountInList(email, password);
//                while (!validate) {
//                    Log.d(TAG,"Email or password are incorrect");
////                    new AlertDialog.Builder(getApplicationContext())
////                            .setTitle("Incorrect Data")
////                            .setMessage("Email or password are incorrect")
////
////                            // Specifying a listener allows you to take an action before dismissing the dialog.
////                            // The dialog is automatically dismissed when a dialog button is clicked.
////                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
////                                public void onClick(DialogInterface dialog, int which) {
////                                    dialog.cancel();
////                                }
////                            })
////
////                            // A null listener allows the button to dismiss the dialog and take no further action.
////                            .setNegativeButton(android.R.string.no, null)
////                            .setIcon(android.R.drawable.ic_dialog_alert)
////                            .show();
//                    validate = isAccountInList(email, password);
//                }
                startActivity(new Intent(getApplicationContext(), HomescreenActivity.class));
                Log.d(TAG, "successfully logged in");
            }
        });
    }

    public void signUp() {
        findViewById(R.id.tv_sign_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
                Log.i(TAG, "clicked sign up");
            }
        });
    }

    public boolean isAccountInList(String email, String password) {
        boolean isInList = false;
        for (Account user: listOfAccounts) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                isInList = true;
            }
        }
        return isInList;
    }
}