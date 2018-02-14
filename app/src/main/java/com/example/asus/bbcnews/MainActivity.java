package com.example.asus.bbcnews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.asus.bbcnews.adapter.NewsAdapter;
import com.example.asus.bbcnews.model.News;
import com.example.asus.bbcnews.model.NewsResponse;
import com.example.asus.bbcnews.rest.ApiClient;
import com.example.asus.bbcnews.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    String sources = "bbc-news";
    String apiKey = "20cfb3c3079849c6acad58c3dc1263f8";
    String url = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<NewsResponse> call = apiService.getAppData(sources,apiKey);
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                int statusCode = response.code();
                List<News> news = response.body().getArticles();
                recyclerView.setAdapter(new NewsAdapter(news,R.layout.row_layout,getApplicationContext()));
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {

            }
        });

    }


}

