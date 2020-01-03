package com.example.articlesapp;

import com.google.gson.annotations.SerializedName;

public class ArticleModel {
    @SerializedName("title")
    private String title;
    @SerializedName("photo_Url")
    private String image;
    @SerializedName("body")
    private String body;
    @SerializedName("time")
    private String time;

    public ArticleModel(String title, String image, String body, String time) {
        this.title = title;
        this.image = image;
        this.body = body;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getBody() {
        return body;
    }

    public String getTime() {
        return time;
    }
}
