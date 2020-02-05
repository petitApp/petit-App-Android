package com.example.petit_app;

public class ApiUtils {
    private ApiUtils() {}

    private static final String BASE_URL = "http://192.168.6.129" +
            "/trabajos/petit-api/public/";

    static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
