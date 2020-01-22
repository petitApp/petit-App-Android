package com.example.petit_app;

import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers("Content-Type: application/json")
    @POST("user")
    @FormUrlEncoded
    Call<User> createUser(@Field("email") String email, @Field("password") String password, @Field("user_name") String user_name);
}
