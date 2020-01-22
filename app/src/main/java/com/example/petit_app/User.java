package com.example.petit_app;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("password")
    private String password;
    @SerializedName("email")
    private String email;
    @SerializedName("user_name")
    private String userName;

    public User(String password, String email, String userName) {
        this.password = password;
        this.email = email;
        this.userName = userName;
    }

    public String getPassword() { return password; }
    public void setPassword(String value) { this.password = value; }

    public String getEmail() { return email; }
    public void setEmail(String value) { this.email = value; }

    public String getUserName() { return userName; }
    public void setUserName(String value) { this.userName = value; }
}
