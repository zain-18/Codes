package com.example.srbijanovosti.Network;


import com.example.srbijanovosti.Interface.ApiService;

public class ApiUtils {
    private ApiUtils(){}

    public static final String Base_url="https://newsapi.org/v2/";

    public static ApiService getApiService(){
        return RetrofitClient.getRetrofit(Base_url).create(ApiService.class);
    }



}
