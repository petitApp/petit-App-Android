package com.example.petit_app;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class User {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("user_name")
    @Expose
    private String user_name;

    @SerializedName("location")
    @Expose
    private String location;

    @SerializedName("picture")
    @Expose
    private String picture;

    @SerializedName("birthday")
    @Expose
    private Date birthday;

    @SerializedName("email_verified_at")
    @Expose
    private long email_verified_at;

    @SerializedName("admin_user")
    @Expose
    private boolean admin_user;

    @SerializedName("active")
    @Expose
    private boolean active;

    @SerializedName("token")
    @Expose
    private String token;



    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setEmail_verified_at(long email_verified_at) {
        this.email_verified_at = email_verified_at;
    }

    public void setAdmin_user(boolean admin_user) {
        this.admin_user = admin_user;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setToken(String token) {
        this.token = token;
    }



    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getLocation() {
        return location;
    }

    public String getPicture() {
        return picture;
    }

    public Date getBirthday() {
        return birthday;
    }

    public long getEmail_verified_at() {
        return email_verified_at;
    }

    public boolean isAdmin_user() {
        return admin_user;
    }

    public boolean isActive() {
        return active;
    }

    public String getToken() {
        return token;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", user_name='" + user_name + '\'' +
                ", location='" + location + '\'' +
                ", picture='" + picture + '\'' +
                ", birthday=" + birthday +
                ", email_verified_at=" + email_verified_at +
                ", admin_user=" + admin_user +
                ", active=" + active +
                ", token='" + token + '\'' +
                '}';
    }
}
