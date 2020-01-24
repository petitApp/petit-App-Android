package com.example.petit_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetDetail extends AppCompatActivity {


    TextView namePet, location, distance, detailAge, detailBreed;

    private APIService APIService;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_detail);

        namePet = findViewById(R.id.namePet);
        location = findViewById(R.id.location);
        distance = findViewById(R.id.distance);
        detailAge = findViewById(R.id.detailAge);
        detailBreed = findViewById(R.id.detailBreed);
        APIService = ApiUtils.getAPIService();

        getAnimalInfo();
    }


    private void getAnimalInfo()
    {
        Call<String> call = APIService.getInfo();
        call.enqueue(new Callback<String>(){
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                    String petName = response.body();
                    namePet.setText(petName);

                    Log.d("RESPONSE_OK", "posts loaded from API");
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("RESPONSE_FAILURE", "error loading from API");

            }
        });
    }

}
