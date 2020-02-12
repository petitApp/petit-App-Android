package com.example.petit_app;

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
import android.widget.Button;
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
    LinearLayout layoutBreedFilter, layoutAgeFilter, dogFilterButton, catFilterButton, otherPetFilterButton ;
    TextView infoBreedFilter, infoDistanceFilter, infoAgeFilter;
    Animal animal = new Animal();
    Button buttonAgeFilter, buttonBreedFilter;
int check = 1;
    int progressBar = 0;
    String showNumberSeekBar;
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

        buttonAgeFilter = (Button)   RootView.findViewById((R.id.buttonAgeFilter));
        buttonBreedFilter = (Button)   RootView.findViewById((R.id.buttonBreedFilter));
        otherPetFilterButton = (LinearLayout) RootView.findViewById((R.id.otherPetFilterButton));
        catFilterButton = (LinearLayout) RootView.findViewById((R.id.catFilterButton));
        dogFilterButton = (LinearLayout) RootView.findViewById((R.id.dogFilterButton));
        layoutAgeFilter = (LinearLayout) RootView.findViewById((R.id.layoutAgeFilter));
        layoutBreedFilter = (LinearLayout) RootView.findViewById((R.id.layoutBreedFilter));

        seekBarFilter = (SeekBar) RootView.findViewById((R.id.seekBarFilter));
        breedFilterET = (EditText) RootView.findViewById((R.id.breedFilterET));
        ageFilterET = (EditText) RootView.findViewById((R.id.ageFilterET));

        infoBreedFilter = (TextView)  RootView.findViewById((R.id.infoBreedFilter));
        infoDistanceFilter = (TextView)  RootView.findViewById((R.id.infoDistanceFilter));
        infoAgeFilter = (TextView)  RootView.findViewById((R.id.infoAgeFilter));


        APIService = ApiUtils.getAPIService();
        adapterImagesPets = new AdapterImagesPets(getActivity().getApplicationContext(), R.layout.item_card_pet, animal.animals, this);
        getAnimalInfo();



        seekBarFilter.setVisibility(View.GONE);

        dogFilterButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                dogFilterButton.setBackgroundResource(R.drawable.custom_buttom_selected_dog);
                catFilterButton.setBackgroundResource(R.drawable.custom_button_filter_cat);
                otherPetFilterButton.setBackgroundResource(R.drawable.custom_button_filter_others);


            }


        });
        catFilterButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                catFilterButton.setBackgroundResource(R.drawable.custom_buttom_selected_cat);
                dogFilterButton.setBackgroundResource(R.drawable.custom_button_filter_dog);
                otherPetFilterButton.setBackgroundResource(R.drawable.custom_button_filter_others);

            }
        });
        otherPetFilterButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                otherPetFilterButton.setBackgroundResource(R.drawable.custom_buttom_selected_others);
                catFilterButton.setBackgroundResource(R.drawable.custom_button_filter_cat);
                dogFilterButton.setBackgroundResource(R.drawable.custom_button_filter_dog);

            }

        });


    tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

        boolean visibility = true;

            @Override
            public void onTabSelected(TabLayout.Tab raceFilter) {
                switch (tabs.getSelectedTabPosition()) {
                    case 0:
                        layoutBreedFilter.setVisibility(View.VISIBLE);
                        seekBarFilter.setVisibility(View.GONE);
                        layoutAgeFilter.setVisibility(View.GONE);





                        break;

                    case 1:
                        seekBarFilter.setVisibility(View.VISIBLE);
                        infoDistanceFilter.setVisibility(View.VISIBLE);
                        layoutBreedFilter.setVisibility(View.GONE);
                        layoutAgeFilter.setVisibility(View.GONE);

                        break;

                    case 2:

                        layoutAgeFilter.setVisibility(View.VISIBLE);
                        seekBarFilter.setVisibility(View.GONE);
                        layoutBreedFilter.setVisibility(View.GONE);
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                switch (tabs.getSelectedTabPosition()) {
                    case 0:

                        seekBarFilter.setVisibility(View.GONE);
                        layoutAgeFilter.setVisibility(View.GONE);

                        if(layoutBreedFilter.getVisibility() == View.VISIBLE){
                            layoutBreedFilter.setVisibility(View.GONE);

                        }else{
                            layoutBreedFilter.setVisibility(View.VISIBLE);
                        }
                        break;

                    case 1:

                        infoDistanceFilter.setVisibility(View.VISIBLE);
                        layoutBreedFilter.setVisibility(View.GONE);
                        layoutAgeFilter.setVisibility(View.GONE);

                        if(seekBarFilter.getVisibility() == View.VISIBLE){
                            seekBarFilter.setVisibility(View.GONE);

                        }else{
                            seekBarFilter.setVisibility(View.VISIBLE);
                        }

                        break;

                    case 2:
                        seekBarFilter.setVisibility(View.GONE);
                        layoutBreedFilter.setVisibility(View.GONE);

                        if(layoutAgeFilter.getVisibility() == View.VISIBLE){
                            layoutAgeFilter.setVisibility(View.GONE);

                        }else{
                            layoutAgeFilter.setVisibility(View.VISIBLE);
                        }
                        break;
                }

            }
        });

        buttonAgeFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String infoAgeTextFilter = ageFilterET.getText().toString();
                if(!infoAgeTextFilter.isEmpty()){
                    infoAgeFilter.setText(infoAgeTextFilter);
                    layoutAgeFilter.setVisibility(View.GONE);
                }else{
                    layoutAgeFilter.setVisibility(View.GONE);
                    Toast.makeText(getActivity(), "You haven't written any age", Toast.LENGTH_SHORT).show();
                }

            }
        });

        buttonBreedFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String infoBreedTextFilter = breedFilterET.getText().toString();
                if(!infoBreedTextFilter.isEmpty()){
                    infoBreedFilter.setText(infoBreedTextFilter);
                    layoutBreedFilter.setVisibility(View.GONE);
                }else{
                    layoutBreedFilter.setVisibility(View.GONE);
                    Toast.makeText(getActivity(), "You haven't written any breed", Toast.LENGTH_SHORT).show();
                }


            }
        });

        seekBarFilter.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                progressBar = progress;
                showNumberSeekBar = String.valueOf(progressBar);
                infoDistanceFilter.setText(showNumberSeekBar);
                Log.d("progress bar", String.valueOf(progressBar));


            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }});

        return RootView;
    }




    private int selectedButtonFilter(int check, LinearLayout linearLayout){


        if(check ==1){
            linearLayout.setBackgroundResource(R.drawable.custom_buttom_selected_dog);
            check = 0;
        }else{
            linearLayout.setBackgroundResource(R.drawable.custom_buttom_loading);
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
//                Log.d("RESPONSE_OK", animal.animals.toString());

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
