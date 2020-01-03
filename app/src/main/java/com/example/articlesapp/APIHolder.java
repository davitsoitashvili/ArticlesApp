package com.example.articlesapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIHolder {
    @GET("/?format=json")
    Call<List<ArticleModel>> getArticles();
}
