package com.example.petit_app;

import android.app.AppComponentFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


@RequiresApi(api = Build.VERSION_CODES.P)

public class RegisterActivity extends AppCompatActivity {

    EditText input_email, input_password, input_username, input_name, input_address, input_phone_number;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        input_username = findViewById(R.id.input_username);
        input_name = findViewById(R.id.input_name);
        input_address = findViewById(R.id.input_address);
        input_phone_number = findViewById(R.id.input_phone_number);
        btn_register = findViewById(R.id.btn_register);
    }


    protected void onResume() {
        super.onResume();

        //Click Listener del botón del login
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = input_email.getText().toString();
                String pass = input_password.getText().toString();
                String username = input_username.getText().toString();
                String name = input_name.getText().toString();
                String address = input_address.getText().toString();
                String phone_number = input_phone_number.getText().toString();

                checkInputs(email, pass, username, name, address, phone_number);
            }
        });
    }

    //Method to check inputs of the login view
    private void checkInputs(String email, String pass, String username, String name, String address, String phone_number) {

        //Check if inputs are empty
        if (email.isEmpty() || pass.isEmpty() || username.isEmpty() || name.isEmpty() || address.isEmpty()) {
            (Toast.makeText(getApplicationContext(), "Empty inputs are not allowed", Toast.LENGTH_LONG)).show();
        } else {

            if (checkEmail(email) == true && checkPass(pass) == true && checkPhoneNumber(phone_number)) {
                (Toast.makeText(getApplicationContext(), "Welcome to Pet it", Toast.LENGTH_LONG)).show();
            }
        }

    }

    private boolean checkEmail(String email) {
        //Check email comparing to the email that arrived through parameters
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            (Toast.makeText(getApplicationContext(), "Introduce a correct email", Toast.LENGTH_LONG)).show();
            return false;
        }
        return true;
    }

    private boolean checkPass(String pass) {
        if (pass.length() <= 8) {
            (Toast.makeText(getApplicationContext(), "The password must be greater than 8 digits", Toast.LENGTH_LONG)).show();
            return false;
        }
        if (!pass.matches("(?=.*[0-9]).*")) {
            (Toast.makeText(getApplicationContext(), "The password must contains at least one number", Toast.LENGTH_LONG)).show();
            return false;
        }
        if (!pass.matches("(?=.*[A-Z]).*")) {
            (Toast.makeText(getApplicationContext(), "The password must contains one upper case letter", Toast.LENGTH_LONG)).show();
            return false;
        }

        return true;
    }

    private boolean checkPhoneNumber(String phoneNumber) {
        int number = Integer.parseInt(phoneNumber);

        if (number >= 9) {
            (Toast.makeText(getApplicationContext(), "The Phone Number must be greater than 9 digits", Toast.LENGTH_LONG)).show();
            return false;
        }
        return true;
    }

}