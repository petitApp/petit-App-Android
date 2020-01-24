package com.example.petit_app;

import com.google.gson.annotations.SerializedName;

public class Animal {

    public Animal(String name, String sex, String age, String location, String description,
                  String prefered_photo, String id_owner, String id_breed) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.location = location;
        this.description = description;
        this.prefered_photo = prefered_photo;
        this.id_owner = id_owner;
        this.id_breed = id_breed;
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

    public String getPrefered_photo() {
        return prefered_photo;
    }

    public void setPrefered_photo(String prefered_photo) {
        this.prefered_photo = prefered_photo;
    }

    public String getId_owner() {
        return id_owner;
    }

    public void setId_owner(String id_owner) {
        this.id_owner = id_owner;
    }

    public String getId_breed() {
        return id_breed;
    }

    public void setId_breed(String id_breed) {
        this.id_breed = id_breed;
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
    @SerializedName("id_breed")
    private String id_breed;

}
