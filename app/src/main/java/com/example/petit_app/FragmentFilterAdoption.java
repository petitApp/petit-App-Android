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
    ArrayList<Animal> elementItemArray = new ArrayList<>();


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

        Animal animal = new Animal("Simba","masculino","Avd Fuenlabrada");
        elementItemArray.add(animal);
        elementItemArray.add(animal);
        elementItemArray.add(animal);
        adapterImagesPets = new AdapterImagesPets(getActivity().getApplicationContext(), R.layout.item_card_pet, elementItemArray);
        gridView.setAdapter(adapterImagesPets);

        seekBarFilter.setVisibility(View.GONE);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                FragmentPetDetail fragmentPetDetail = new FragmentPetDetail();
                ((MainActivity)getActivity()).addFragment(fragmentPetDetail);

                adapterImagesPets.notifyDataSetChanged();
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


}
