package com.example.asus.bbcnews.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2/13/2018.
 */

public class NewsResponse {

    @SerializedName("status")
    private String status;
    @SerializedName("totalResults")
    private int totalResults;
    @SerializedName("articles")
    private List<News> articles = new ArrayList<News>();

    public void setStatus(String status){
        this.status = status;
    }

    public void setTotalResults(int totalResults){
        this.totalResults = totalResults;
    }

    public void setArticles(List<News> articles){
        this.articles = articles;
    }

    public String getStatus(){
        return status;
    }

    public int getTotalResults(){
        return totalResults;
    }

    public List<News> getArticles() {
        return articles;
    }
}
