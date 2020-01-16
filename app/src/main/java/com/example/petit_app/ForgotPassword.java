package com.example.petit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ForgotPassword extends AppCompatActivity {
EditText input_email_forgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        input_email_forgotPassword = findViewById(R.id.input_email_forgotPassword);


    }

    public void returnLogin(View view) {

        String emailForgotPassword = input_email_forgotPassword.getText().toString();
        if(emailForgotPassword.isEmpty()){
            input_email_forgotPassword.setError("Empty inputs are not allowed");

        }else{
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
