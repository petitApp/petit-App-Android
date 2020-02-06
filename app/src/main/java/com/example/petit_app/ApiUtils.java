package com.example.petit_app;

public class ApiUtils {
    private ApiUtils() {}

    private static final String BASE_URL = "http://192.168.6.58" +
            "/petit-api-feature-animal-crud/public/";

    static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
