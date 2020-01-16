package com.example.petit_app;

import android.app.AppComponentFactory;
import android.app.DatePickerDialog;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


@RequiresApi(api = Build.VERSION_CODES.P)

public class RegisterActivity extends AppCompatActivity {

    EditText input_email, input_password, input_username, input_confirm_password ;
    Button btn_register, btn_birthday;
    Date calendar;
    Fragment fragment;
    private int mYear, mMonth, mDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        input_username = findViewById(R.id.input_username);
        btn_birthday = findViewById(R.id.btn_birthday);
        btn_register = findViewById(R.id.btn_register);
        input_confirm_password = findViewById(R.id.input_confirm_password);

        btn_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new CalendarFragment();
                newFragment.show(getSupportFragmentManager(), "datePicker");
            }

        });
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
                String confirmPass = input_confirm_password.getText().toString();

                checkInputsRegister(email, pass, username, confirmPass);
            }
        });




    }

    //Method to check inputs of the login view
    private void checkInputsRegister(String email, String pass, String username, String confirmPass) {

        //Check if inputs are empty
        if (email.isEmpty())  {
            input_email.setError("Empty inputs are not allowed");
        }
        if(pass.isEmpty()){
            input_password.setError("Empty inputs are not allowed");
        }

        if(username.isEmpty()){
            input_username.setError("Empty inputs are not allowed");
        }
        else {
            checkEmail(email);
            checkCalendar(calendar);
            checkPass(pass);
            if (checkEmail(email) == true && checkCalendar(calendar) == true && checkPass(pass) == true) {
                if(confirmPassword(pass, confirmPass)){
                    (Toast.makeText(getApplicationContext(), "Welcome to Pet it", Toast.LENGTH_LONG)).show();
                }
            }
        }
    }

    private boolean checkEmail(String email) {
        //Check email comparing to the email that arrived through parameters
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            input_email.setError("Introduce a correct email");
            (Toast.makeText(getApplicationContext(), "Introduce a correct email", Toast.LENGTH_LONG)).show();
            return false;
        }
        return true;
    }

    private boolean checkPass(String pass) {
        if (pass.length() <= 8) {
            input_password.setError("The password must be greater than 8 digits");
            (Toast.makeText(getApplicationContext(), "The password must be greater than 8 digits", Toast.LENGTH_LONG)).show();
            return false;
        }
        if (!pass.matches("(?=.*[0-9]).*")) {
            input_password.setError("The password must contains at least one number");
            (Toast.makeText(getApplicationContext(), "The password must contains at least one number", Toast.LENGTH_LONG)).show();
            return false;
        }
        if (!pass.matches("(?=.*[A-Z]).*")) {
            input_password.setError("The password must contains one upper case letter");
            (Toast.makeText(getApplicationContext(), "The password must contains one upper case letter", Toast.LENGTH_LONG)).show();
            return false;
        }

        return true;
    }

    private boolean checkCalendar(Date calendar) {


        if (calendar == null) {
            (Toast.makeText(getApplicationContext(), "You have to fill the birthday", Toast.LENGTH_LONG)).show();
            return false;
        }
        Log.d("fecha actual", String.valueOf(calendar));

        return true;
    }


    private boolean confirmPassword(String password , String confirmPassword){

        if(!password.equals(confirmPassword) ){
            input_confirm_password.setError("Introduce the same password");
            Log.d("tusmuertos", password);
            Log.d("tusmuertos2", confirmPassword);
            return false;
        }
        return true;
    }

    //Calendar function
    //Enviar los datos del calendario al activity
    public void sendDatePicker(Date datePicker){

        calendar = datePicker;

        Log.d("Valor del calendario", String.valueOf(calendar));
     //   recievedDataCalendar(calendar, (CalendarFragment)fragment);
    }




}