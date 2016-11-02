package com.jandzy.news.http;

import com.jandzy.news.model.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by jrazy on 2016/11/2.
 */
public interface NewsService {

    @GET("toutiao/index")
    Call<NewsModel> getNewsList(@Header("key") String key, @Query("type") String type);
}
