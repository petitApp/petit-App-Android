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

public class AdapterImagesPets  extends ArrayAdapter {

    Context context;
    int item_Layaut;
    ArrayList<Animal> data;

    public AdapterImagesPets(@NonNull Context context, int item_Layaut, GetAnimalsRS data) {
        super(context, item_Layaut, Collections.singletonList(data));
        this.context = context;
        this.item_Layaut = item_Layaut;
        this.data = data.animals;
    }

    public void setData(GetAnimalsRS data) {
        this.data = data.animals;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){

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

        String location = data.get(position).getName();
        TextView elementLocation = convertView.findViewById(R.id.locationPetCard);
        elementLocation.setText(location);

        return convertView;
    }



}