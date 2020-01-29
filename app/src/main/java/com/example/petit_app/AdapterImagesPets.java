package com.example.petit_app;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class AdapterImagesPets  extends ArrayAdapter {

    Context context;
    int item_Layaut;
    ArrayList<Animal> data;

    public AdapterImagesPets(@NonNull Context context, int item_Layaut, ArrayList data) {
        super(context, item_Layaut, data);
        this.context = context;
        this.item_Layaut = item_Layaut;
        this.data = data;
    }
    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(item_Layaut, parent, false);
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
        elementName.setText(name);

        return convertView;
    }



}