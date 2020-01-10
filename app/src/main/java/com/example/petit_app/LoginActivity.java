package com.example.petit_app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = input_email.getText().toString();
                String pass = input_password.getText().toString();

                checkInputs(email , pass);
            }
        });
    }

    //Method to check inputs of the login view
    private void checkInputs(String email ,String pass){

        //Check if inputs are empty
        if (email.isEmpty() || pass.isEmpty()) {
            (Toast.makeText(getApplicationContext() , "Empty inputs are not allowed", Toast.LENGTH_LONG)).show();
        } else {
            checkEmail(email);
            checkPass(pass);
        }

    }

    private void checkEmail(String email){
        //Check email comparing to the email that arrived through parameters
        email.matches("\"^(.+)@(.+)$\"");
    }

    private void checkPass(String pass){

        if(pass.length() <= 8){
            (Toast.makeText(getApplicationContext() , "The password must be greater than 8 digits", Toast.LENGTH_LONG)).show();
        }
        if(!pass.matches("(?=.*[0-9]).*")){
            (Toast.makeText(getApplicationContext() , "The password must contains at least one digit", Toast.LENGTH_LONG)).show();
        }
        if(!pass.matches("(?=.*[A-Z]).*")){
            (Toast.makeText(getApplicationContext() , "The password must contains one upper case letter", Toast.LENGTH_LONG)).show();
        }


    }

}
