package com.example.hackathonapp.account;

public class Account {
    private static int idAccount = 0;
    private String email;
    private String password;

    Account() {
        email = "";
        password = "";
    }

    public void setEmail(String em) {
        email = em;
    }

    public void setPassword(String pass) {
        password = pass;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    static void updateAccountNumber() {
        idAccount += 1;
    }
}
