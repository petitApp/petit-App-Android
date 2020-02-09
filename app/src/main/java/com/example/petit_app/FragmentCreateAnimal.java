package com.example.petit_app;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.DocumentsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class FragmentCreateAnimal extends Fragment {
    private APIService APIService;
    Dialog dialogLoading;
    Button btn_add_animal;
    EditText namePet, petDescription, detailBreed;
    SeekBar detailAge;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_create_animal, container, false);

        APIService = ApiUtils.getAPIService();
        dialogLoading = new Dialog(this.getContext());
        btn_add_animal = (Button) RootView.findViewById(R.id.btn_add_animal);
        namePet = (EditText) RootView.findViewById(R.id.namePet);
        petDescription = (EditText) RootView.findViewById(R.id.petDescription);
        detailAge = (SeekBar) RootView.findViewById(R.id.detailAge);
        detailBreed = (EditText) RootView.findViewById(R.id.detailBreed);

        btn_add_animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = namePet.getText().toString();
                String age = String.valueOf(detailAge.getProgress());
                String type = "Perro";
                String sex = "Macho";
                String latitude = "333.333";
                String longitude = "333.333";
           //     String description = petDescription.getText().toString();
                String available = "Yes";
                String id_owner = "1";
                String picture = "drawable://" + R.drawable.icon_location;
                String breed = detailBreed.getText().toString();


           //     createAnimal(name, age, type, sex, latitude, longitude, description, available, id_owner, picture, breed);

            }
        });



        return RootView;




    }
    private void createAnimal(String name, String age, String type, String sex,  String description, String latitude, String longitude,
                              String available, String id_owner, String picture, String breed)
    {
        Log.d("eeer","addede");
        Log.d("OBJETO:", name);
        dialogLoading.show();
        dialogLoading.setCancelable(false);

        Animal animal = new Animal( name,  age,  type,  sex,   description,  latitude,  longitude,
                 available,  id_owner,  picture,  breed);
        APIService.sendInfo(animal).enqueue(new Callback<Animal>() {
            @Override
            public void onResponse(Call<Animal> call, Response<Animal> response) {
                dialogLoading.dismiss();
                Log.d("RESPUESTA DEL MENSAJE", response.toString());
                Log.d("eeer","response");
                if(response.isSuccessful()) {
                    Log.d("RESPUESTA DEL MENSAJE", response.toString());
                    Log.d("eeer","sucses");
                }
            }

            @Override
            public void onFailure(Call<Animal> call, Throwable t) {

                dialogLoading.dismiss();
                Log.d("eeer","fallo");
            }
        });


    }
}
