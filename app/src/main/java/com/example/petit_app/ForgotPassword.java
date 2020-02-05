package com.example.petit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPassword extends AppCompatActivity {

    EditText input_email_forgotPassword;
    Button btn_recover;
    private APIService APIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        APIService = ApiUtils.getAPIService();
        input_email_forgotPassword = findViewById(R.id.input_email_forgotPassword);
        btn_recover = findViewById(R.id.btn_recover);

    }

    @Override
    protected void onResume() {
        super.onResume();

        btn_recover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = input_email_forgotPassword.getText().toString();
                checkEmailInput(email);
            }
        });

    }

    private void checkEmailInput(String email) {

        //Check if inputs are empty
        if (email.isEmpty()) {
            input_email_forgotPassword.setError("Empty inputs are not allowed");
        }
        else if(checkEmail(email)){
            (Toast.makeText(getApplicationContext(), "Email sent", Toast.LENGTH_LONG)).show();
            recoverPOST(email);
        }else{
            Log.d("tusmuertos", email);
        }
    }

    private boolean checkEmail(String email) {
        //Check email comparing to the email that arrived through parameters
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            input_email_forgotPassword.setError("Introduce a correct email");
            return false;
        }
        return true;
    }

    private void recoverPOST(String email)
    {



        User user = new User(email);
        APIService.recoverPass(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {

                    Log.d("RESPUESTA DEL MENSAJE", response.toString());
                    Intent intent = new Intent(ForgotPassword.this, LoginActivity.class );
                    startActivity(intent);


                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "User not found o algo de eso", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
