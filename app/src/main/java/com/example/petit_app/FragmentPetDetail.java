package com.example.petit_app;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentPetDetail extends Fragment  {


    TextView namePet, location, distance, detailAge, detailBreed;

    private APIService APIService;
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_pet_detail, container, false);


        namePet =  RootView.findViewById(R.id.namePet);
        location = RootView.findViewById(R.id.location);
        distance = RootView.findViewById(R.id.distance);
        detailAge = RootView.findViewById(R.id.detailAge);
        detailBreed = RootView.findViewById(R.id.detailBreed);
        APIService = ApiUtils.getAPIService();




        return RootView;
    }


}
