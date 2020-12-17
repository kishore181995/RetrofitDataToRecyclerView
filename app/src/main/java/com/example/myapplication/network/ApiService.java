package com.example.myapplication.network;


import com.example.myapplication.models.Example;
import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    String BASE_URL = "https://run.mocky.io/v3/";

    @Headers({
            "Accept: application/json",
    })
    @GET("{id}")
    Call<List<Example>> getCoupounsdata(@Path("id") String id);



}
