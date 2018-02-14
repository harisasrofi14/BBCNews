package com.example.asus.bbcnews.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by asus on 2/12/2018.
 */

public class News {

    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("url")
    private String url;
    @SerializedName("urlToImage")
    private String urlToImage;
    @SerializedName("publishedAt")
    private String publishedAt;

    public News (String title,String description,String url,String urlToImage,String publishedAt){
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setUrl (String url){
        this.url = url;
    }

    public void setImageUrl(String ImageUrl){
        this.urlToImage= ImageUrl;
    }

    public void setDate(String date){
        this.publishedAt = date;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public String getUrl(){
        return url;
    }

    public String getImageUrl(){
        return urlToImage;
    }

    public String getDate(){
        return publishedAt;
    }
}
