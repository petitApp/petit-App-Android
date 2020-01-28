package com.example.petit_app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabItem;

import java.util.ArrayList;


/**

 */
public class FragmentFilterAdoption extends Fragment {

    AdapterImagesPets adapterImagesPets;
    GridView gridView;
    TabItem ageFilter,distanceFilter, raceFilter;
    LinearLayout dogFilterButton, catFilterButton, otherPetFilterButton;
    ArrayList<Animal> elementItemArray = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_filter_adoption, container, false);

        gridView = (GridView) RootView.findViewById((R.id.gridView));
        ageFilter = (TabItem) RootView.findViewById((R.id.ageFilter));
        distanceFilter = (TabItem) RootView.findViewById((R.id.distanceFilter));
        raceFilter = (TabItem) RootView.findViewById((R.id.raceFilter));

        otherPetFilterButton = (LinearLayout) RootView.findViewById((R.id.otherPetFilterButton));
        catFilterButton = (LinearLayout) RootView.findViewById((R.id.catFilterButton));
        dogFilterButton = (LinearLayout) RootView.findViewById((R.id.dogFilterButton));

        Animal animal = new Animal("Simba","masculino","Avd Fuenlabrada");
        elementItemArray.add(animal);
        elementItemArray.add(animal);
        elementItemArray.add(animal);
        adapterImagesPets = new AdapterImagesPets(getActivity().getApplicationContext(), R.layout.item_card_pet, elementItemArray);
        gridView.setAdapter(adapterImagesPets);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                FragmentPetDetail fragmentPetDetail = new FragmentPetDetail();
                ((MainActivity)getActivity()).addFragment(fragmentPetDetail);

                adapterImagesPets.notifyDataSetChanged();
            }
        });


        return RootView;
    }


}
