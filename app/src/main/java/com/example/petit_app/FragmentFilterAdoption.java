package com.example.petit_app;

import android.content.Intent;
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
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


/**

 */
public class FragmentFilterAdoption extends Fragment implements AdapterImagesPets.ClickOnPet{

    AdapterImagesPets adapterImagesPets;
    GridView gridView;
    TabLayout tabs;
    SeekBar seekBarFilter;
    EditText breedFilterET, ageFilterET;
    TabItem ageFilter,distanceFilter, raceFilter;
    LinearLayout dogFilterButton, catFilterButton, otherPetFilterButton ;
    Animal animal = new Animal();

    private int check = 1;

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


        otherPetFilterButton = (LinearLayout) RootView.findViewById((R.id.otherPetFilterButton));
        catFilterButton = (LinearLayout) RootView.findViewById((R.id.catFilterButton));
        dogFilterButton = (LinearLayout) RootView.findViewById((R.id.dogFilterButton));

        seekBarFilter = (SeekBar) RootView.findViewById((R.id.seekBarFilter));
        breedFilterET = (EditText) RootView.findViewById((R.id.breedFilterET));
        ageFilterET = (EditText) RootView.findViewById((R.id.ageFilterET));


        APIService = ApiUtils.getAPIService();
        adapterImagesPets = new AdapterImagesPets(getActivity().getApplicationContext(), R.layout.item_card_pet, animal.animals, this);
        getAnimalInfo();


        seekBarFilter.setVisibility(View.GONE);

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
                        breedFilterET.setVisibility(View.VISIBLE);
                        seekBarFilter.setVisibility(View.GONE);
                        ageFilterET.setVisibility(View.GONE);
                        break;

                    case 1:
                        seekBarFilter.setVisibility(View.VISIBLE);
                        breedFilterET.setVisibility(View.GONE);
                        ageFilterET.setVisibility(View.GONE);
                        break;
                    case 2:
                        ageFilterET.setVisibility(View.VISIBLE);
                        seekBarFilter.setVisibility(View.GONE);
                        breedFilterET.setVisibility(View.GONE);
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


    private int selectedButtonFilter(int check, LinearLayout linearLayout){


        if(check ==1){
            linearLayout.setBackgroundResource(R.drawable.custom_buttom_selected);
            check = 0;
        }else{
            linearLayout.setBackgroundResource(R.drawable.custom_buttom_filter_animal);
            check = 1;
        }

        return check;
     //   Log.d(TAG, String.valueOf(check));

    }
    private void getAnimalInfo()
    {
        Call<Animal> call = APIService.getInfo();
        call.enqueue(new Callback<Animal>(){
            @Override
            public void onResponse(Call<Animal> call, Response<Animal> response) {
                animal = response.body();
                adapterImagesPets.notifyDataSetInvalidated();
                adapterImagesPets.setData(animal);
                gridView.setAdapter(adapterImagesPets);
                Log.d("RESPONSE_OK", animal.animals.toString());

            }

            @Override
            public void onFailure(Call<Animal> call, Throwable t) {
                Log.d("RESPONSE_FAILURE", "error loading from API");

            }
        });
    }


    @Override
    public void onClick(Animal animal) {
        FragmentPetDetail fragmentPetDetail = new FragmentPetDetail(animal);
        ((MainActivity)getActivity()).addFragment(fragmentPetDetail);

    }

}
