package com.example.petit_app;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


/**

 */
public class FragmentFilterAdoption extends Fragment {

    AdapterImagesPets adapterImagesPets;
    GridView gridView;
    TabLayout tabs;
    TabItem ageFilter,distanceFilter, raceFilter;
    LinearLayout dogFilterButton, catFilterButton, otherPetFilterButton, seekBarFilter;
    ArrayList<Animal> petsArrayGrid = new ArrayList<>();
    GetAnimalsRS getAnimalsRS = new GetAnimalsRS();
    Animal animal;


    private APIService APIService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_filter_adoption, container, false);

        gridView = (GridView) RootView.findViewById((R.id.gridView));
        tabs = (TabLayout) RootView.findViewById((R.id.tabs));
        ageFilter = (TabItem) RootView.findViewById((R.id.ageFilter));
        distanceFilter = (TabItem) RootView.findViewById((R.id.distanceFilter));
        raceFilter = (TabItem) RootView.findViewById((R.id.raceFilter));

        seekBarFilter = (LinearLayout) RootView.findViewById((R.id.seekBarFilter));
        otherPetFilterButton = (LinearLayout) RootView.findViewById((R.id.otherPetFilterButton));
        catFilterButton = (LinearLayout) RootView.findViewById((R.id.catFilterButton));
        dogFilterButton = (LinearLayout) RootView.findViewById((R.id.dogFilterButton));


        APIService = ApiUtils.getAPIService();

        //getAnimalInfo();


        seekBarFilter.setVisibility(View.GONE);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                FragmentPetDetail fragmentPetDetail = new FragmentPetDetail();
                ((MainActivity)getActivity()).addFragment(fragmentPetDetail);

                adapterImagesPets.notifyDataSetChanged();
            }
        });

        dogFilterButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                dogFilterButton.setBackgroundResource(R.drawable.custom_buttom_selected);
                catFilterButton.setBackgroundResource(R.drawable.custom_buttom_filter_animal);
                otherPetFilterButton.setBackgroundResource(R.drawable.custom_buttom_filter_animal);
            }
        });
        catFilterButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                catFilterButton.setBackgroundResource(R.drawable.custom_buttom_selected);
                dogFilterButton.setBackgroundResource(R.drawable.custom_buttom_filter_animal);
                otherPetFilterButton.setBackgroundResource(R.drawable.custom_buttom_filter_animal);
            }
        });
        otherPetFilterButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                otherPetFilterButton.setBackgroundResource(R.drawable.custom_buttom_selected);
                catFilterButton.setBackgroundResource(R.drawable.custom_buttom_filter_animal);
                dogFilterButton.setBackgroundResource(R.drawable.custom_buttom_filter_animal);
            }

        });


        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab raceFilter) {
                switch (tabs.getSelectedTabPosition()) {
                    case 0:
                        seekBarFilter.setVisibility(View.GONE);
                        break;

                    case 1:
                        seekBarFilter.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        seekBarFilter.setVisibility(View.GONE);
                        break;

                }

            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
               
            }
        });


        return RootView;
    }


    private void getAnimalInfo()
    {
        Call<GetAnimalsRS> call = APIService.getInfo();
        call.enqueue(new Callback<GetAnimalsRS>(){
            @Override
            public void onResponse(Call<GetAnimalsRS> call, Response<GetAnimalsRS> response) {
                getAnimalsRS = response.body();

                adapterImagesPets = new AdapterImagesPets(getActivity().getApplicationContext(), R.layout.item_card_pet, getAnimalsRS);
                adapterImagesPets.setData(getAnimalsRS);
                gridView.setAdapter(adapterImagesPets);


                Log.d("RESPONSE_OK", getAnimalsRS.animals.toString());

            }

            @Override
            public void onFailure(Call<GetAnimalsRS> call, Throwable t) {
                Log.d("RESPONSE_FAILURE", "error loading from API");

            }
        });
    }


}
