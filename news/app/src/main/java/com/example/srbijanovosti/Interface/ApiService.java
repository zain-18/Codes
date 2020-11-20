package com.example.srbijanovosti.Interface;

import com.example.srbijanovosti.Model.NewsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("top-headlines")
    Call<NewsModel> getNews(@Query("country") String country,@Query("apiKey") String apiKey);
}
