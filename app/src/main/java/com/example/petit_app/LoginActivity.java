package com.example.petit_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText input_email, input_password;
    Button loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        loginBtn = findViewById(R.id.btn_login);

    }

    @Override
    protected void onResume() {
        super.onResume();


        //Click Listener del botón del login
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = input_email.getText().toString();
                String pass = input_password.getText().toString();
                checkInputs(email, pass);
            }
        });

    }

    //Method to check inputs of the login view
    private void checkInputs(String email, String pass) {

        //Check if inputs are empty
        if (email.isEmpty()) {
            input_email.setError("Empty inputs are not allowed");

        }
        if( pass.isEmpty()){
            input_password.setError("Empty inputs are not allowed");
        }
        else {
                (Toast.makeText(getApplicationContext(), "Welcome to Pet it", Toast.LENGTH_LONG)).show();
        }
    }

    //Click from login to register view
    public void link_signup(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void link_forgot_password(View view) {
        startActivity(new Intent(this, ForgotPassword.class));
    }
}
