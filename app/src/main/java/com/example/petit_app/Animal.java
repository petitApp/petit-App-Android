package com.example.petit_app;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Animal {

    ArrayList<Animal> animals = new ArrayList<Animal>();

    public Animal(String name, String sex, String age, String location, String description,
                  String prefered_photo, String id_owner, String breed, String type, String latitude, String longitude,
                  String available) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.location = location;
        this.description = description;
        this.prefered_photo = prefered_photo;
        this.id_owner = id_owner;
        this.breed = breed;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.available = available;
    }
    public Animal(String name, String age, String type, String sex,  String description, String latitude, String longitude,
                  String available, String id_owner, String prefered_photo, String breed) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.description = description;
        this.prefered_photo = prefered_photo;
        this.id_owner = id_owner;
        this.breed = breed;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.available = available;
    }

    public Animal(String name, String location, String prefered_photo) {
        this.name = name;
        this.location = location;
        this.prefered_photo = prefered_photo;
    }

    public Animal (String name){
        this.name=name;
    }
    public Animal (){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return prefered_photo;
    }

    public void setPicture(String prefered_photo) {
        this.prefered_photo = prefered_photo;
    }

    public String getId_owner() {
        return id_owner;
    }

    public void setId_owner(String id_owner) {
        this.id_owner = id_owner;
    }

    public String getBreed() {
        return breed;
    }

    public void setId_breed(String breed) {
        this.breed = breed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String longitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @SerializedName("name")
    private String name;
    @SerializedName("sex")
    private String sex;
    @SerializedName("age")
    private String age;
    @SerializedName("location")
    private String location;
    @SerializedName("description")
    private String description;
    @SerializedName("prefered_photo")
    private String prefered_photo;
    @SerializedName("id_owner")
    private String id_owner;
    @SerializedName("breed")
    private String breed;
    @SerializedName("type")
    private String type;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("available")
    private String available;
}
