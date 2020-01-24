package com.example.petit_app;

import android.app.AppComponentFactory;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@RequiresApi(api = Build.VERSION_CODES.P)

public class RegisterActivity extends AppCompatActivity {

    EditText input_email, input_password, input_username, input_confirm_password ;
    Button btn_register;
    CheckBox checkAge;

    private APIService APIService;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        checkAge = findViewById(R.id.checkAge);
        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        input_username = findViewById(R.id.input_username);
        btn_register = findViewById(R.id.btn_register);
        input_confirm_password = findViewById(R.id.input_confirm_password);

        APIService = ApiUtils.getAPIService();



        //Click Listener del botón del login
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 String email = input_email.getText().toString();
                 String pass = input_password.getText().toString();
                 String username = input_username.getText().toString();
                 String confirmPass = input_confirm_password.getText().toString();


                checkInputsRegister(username, email, pass,  confirmPass, checkAge);

            }
        });
    }
    //Method to check inputs of the login view
    private void checkInputsRegister(String username, String email, String pass, String confirmPass, CheckBox age) {

        //Check if inputs are empty
        if(username.isEmpty()){
            Log.d("valor del email", "ëdededede");
            input_username.setError("Empty inputs are not allowed");
        }else{
            Log.d("valor del email", "no está vacio");
            checkUsername(username);
            if (checkEmail(email)==true
                    && checkPass(pass)==true
                    && confirmPassword(pass, confirmPass)==true
                    && validateCheckAge(checkAge)==true
                    &&checkUsername(username)==true) {

                (Toast.makeText(getApplicationContext(), "Welcome to Pet it", Toast.LENGTH_LONG)).show();

            }
        }

        if (email.isEmpty()){
            input_email.setError("Empty inputs are not allowed");
        }else{
            checkEmail(email);
            if (checkEmail(email)==true
                    && checkPass(pass)==true
                    && confirmPassword(pass, confirmPass)==true
                    && validateCheckAge(checkAge)==true
                    &&checkUsername(username)==true) {

                (Toast.makeText(getApplicationContext(), "Welcome to Pet it", Toast.LENGTH_LONG)).show();

            }
        }

        if(pass.isEmpty()){
            confirmPassword(pass, confirmPass);
            input_password.setError("Empty inputs are not allowed");
        }else{
            checkPass(pass);
            if (checkEmail(email)==true
                    && checkPass(pass)==true
                    && confirmPassword(pass, confirmPass)==true
                    && validateCheckAge(checkAge)==true
                    &&checkUsername(username)==true) {

                (Toast.makeText(getApplicationContext(), "Welcome to Pet it", Toast.LENGTH_LONG)).show();

            }
        }

        if(!validateCheckAge(checkAge)){
            (Toast.makeText(getApplicationContext(), "You must be older than 18 years old.", Toast.LENGTH_LONG)).show();
        }else{
            validateCheckAge(checkAge);
            if (checkEmail(email)==true
                    && checkPass(pass)==true
                    && confirmPassword(pass, confirmPass)==true
                    && validateCheckAge(checkAge)==true
                    &&checkUsername(username)==true) {


                (Toast.makeText(getApplicationContext(), "Welcome to Pet it", Toast.LENGTH_LONG)).show();

            }
        }
        registerPOST(pass, email, username);
    }

    private boolean checkEmail(String email) {
        //Check email comparing to the email that arrived through parameters
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            input_email.setError("Introduce a correct email");
            return false;
        }
        return true;
    }
    private boolean checkUsername(String userName){
        if (userName.length() <= 3) {
            input_username.setError("The user name must be greater than 3 characters");
            return false;
        }
        return true;
    }

    private boolean checkPass(String pass) {
        if (pass.length() <= 8) {
            input_password.setError("The password must be greater than 8 characters");
            return false;
        }
        if (!pass.matches("(?=.*[0-9]).*")) {
            input_password.setError("The password must contains at least one number");
            return false;
        }

        return true;
    }


    private boolean confirmPassword(String password , String confirmPassword){

        if(!password.equals(confirmPassword) || password.isEmpty() ){
            input_confirm_password.setError("Introduce the same password");
            Log.d("tusmuertos", password);
            Log.d("tusmuertos2", confirmPassword);
            return false;
        }
        return true;
    }

    private boolean validateCheckAge(CheckBox age){
        if(!age.isChecked()){
            (Toast.makeText(getApplicationContext(), "You must be older than 18 years old.", Toast.LENGTH_LONG)).show();
            return false;
        }
        return true;
    }

    private void registerPOST(String password, String email, String user_name)
    {
        Log.d("eeer","addede");
        Log.d("OBJETO:", email);
        User user1 = new User(password, email, user_name);
        APIService.createUser(user1).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {

                    Log.d("RESPUESTA DEL MENSAJE", response.toString());

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error de conexión", Toast.LENGTH_SHORT).show();

            }
        });


    }


}