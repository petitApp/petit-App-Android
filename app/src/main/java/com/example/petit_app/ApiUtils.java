package com.example.petit_app;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://0.0.0.0:80/trabajos/petit-api/public/api/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
