package com.example.petit_app;

import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers("Content-Type: application/json")
    @POST("api/user")
    Call<User> createUser(@Body User user);
    @POST("api/user/login")
    Call<User> sendUser(@Body User user);
    @POST("api/user/password/reset")
    Call<User> recoverPass(@Body User user);


    @GET("api/animals")
    Call<Animal> getInfo();

    @POST("api/animal")
    Call<Animal> sendInfo(@Body Animal animal);
}
