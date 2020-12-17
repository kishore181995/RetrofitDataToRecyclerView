package com.example.myapplication.network;

public class ApiUtils {

    private ApiUtils() {
    }

    public static ApiService getAPIService() {
        return RetrofitClient.getClient(ApiService.BASE_URL).create(ApiService.class);
    }

}

