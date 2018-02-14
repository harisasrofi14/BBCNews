package com.example.asus.bbcnews.rest;

import com.example.asus.bbcnews.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by asus on 2/13/2018.
 */

public interface ApiInterface {

    @GET("top-headlines")
    Call<NewsResponse> getAppData(@Query("sources") String sources, @Query("apiKey") String apiKey);
}
