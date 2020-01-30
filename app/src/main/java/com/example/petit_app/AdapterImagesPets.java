package com.example.petit_app;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;

public class AdapterImagesPets  extends ArrayAdapter<List<Animal>> {

    Context context;
    int item_Layaut;
    List<Animal> data;
    ClickOnPet listener;

    public AdapterImagesPets(@NonNull Context context, int item_Layaut, List<Animal> data, ClickOnPet listener) {
        super(context, item_Layaut, Collections.singletonList(data));
        this.context = context;
        this.item_Layaut = item_Layaut;
        this.listener = listener;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    public void setData(Animal data) {
        this.data = data.animals;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(final int position, @NonNull View convertView, @NonNull ViewGroup parent){

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(item_Layaut, parent, false);
        }

        if(data == null || data.isEmpty()){
            return null;
        }

        String image = data.get(position).getPrefered_photo();
        Uri imageGallery = Uri.parse(image);
        ImageView elementImage = convertView.findViewById(R.id.imagePetCard);
        elementImage.setImageURI(imageGallery);

        String name = data.get(position).getName();
        TextView elementName = convertView.findViewById(R.id.namePetCard);
        elementName.setText(name);

        String location = data.get(position).getLocation();
        TextView elementLocation = convertView.findViewById(R.id.locationPetCard);
        elementLocation.setText(location);

        elementName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(data.get(position));
            }
        });

        return convertView;
    }

    interface ClickOnPet{
        void onClick(Animal animal);
    }

}