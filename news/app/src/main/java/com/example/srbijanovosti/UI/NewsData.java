package com.example.srbijanovosti.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.srbijanovosti.Adapters.ListaNovostiAdapter;
import com.example.srbijanovosti.Interface.ApiService;
import com.example.srbijanovosti.Model.NewsModel;
import com.example.srbijanovosti.Network.ApiUtils;
import com.example.srbijanovosti.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsData extends AppCompatActivity {
    RecyclerView HeadLinesNews_rv;
    ApiService apiService;
    ListaNovostiAdapter listaNovostiAdapter;
    String countryCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_data);
        Intent intent=getIntent();
        countryCode=intent.getStringExtra("CountryCode");
        init();
        api_Call();
    }

    ///Intailize Widgets
    public void init(){
        HeadLinesNews_rv=findViewById(R.id.HeadLinesNews_rv);

    }

    public void api_Call(){
        apiService= ApiUtils.getApiService();
        apiService.getNews(countryCode,"e2b15072fb34449283fb056ff442f670").enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                //If api response is successfull then it comes in condition
                if(response.isSuccessful()){
                    //Model class
                   NewsModel newsModel=response.body();
                   //passing data Article data in Arraylist
                    ArrayList<NewsModel.Article> articleArrayList= (ArrayList<NewsModel.Article>) newsModel.getArticles();
                    //Setting LayoutManager
                    HeadLinesNews_rv.setLayoutManager(new LinearLayoutManager(NewsData.this));

                    //Intialize Adapter class and pass contructor data
                    listaNovostiAdapter=new ListaNovostiAdapter(NewsData.this,articleArrayList);

                    //Set adapter in RecycleView
                    HeadLinesNews_rv.setAdapter(listaNovostiAdapter);

                }
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {

            }
        });

    }
}