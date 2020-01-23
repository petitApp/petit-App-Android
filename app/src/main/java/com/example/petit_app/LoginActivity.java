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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText input_email, input_password;
    Button loginBtn;
    private APIService APIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        loginBtn = findViewById(R.id.btn_login);
        APIService = ApiUtils.getAPIService();
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
        if (email.isEmpty() || pass.isEmpty()) {
            input_email.setError("Empty inputs are not allowed");

        }
        else if(checkEmail(email) && checkPass(pass)){
                (Toast.makeText(getApplicationContext(), "Welcome to Pet it", Toast.LENGTH_LONG)).show();
                loginPOST(pass,email);
        }else{
            Log.d("tusmuertos", email);
        }
    }
    private boolean checkEmail(String email) {
        //Check email comparing to the email that arrived through parameters
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            input_email.setError("Introduce a correct email");
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
        if (!pass.matches("(?=.*[A-Z]).*")) {
            input_password.setError("The password must contains one upper case letter");
            return false;
        }

        return true;
    }
    //Click from login to register view
    public void link_signup(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void link_forgot_password(View view) {
        startActivity(new Intent(this, ForgotPassword.class));
    }



    private void loginPOST(String password, String email)
    {
        User user2 = new User(password, email);
        APIService.sendUser(user2).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {

                    Log.d("RESPUESTA DEL MENSAJE", response.toString());

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "User polla not found o algo de eso", Toast.LENGTH_SHORT).show();

            }
        });


    }

}
