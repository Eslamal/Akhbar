package com.eslamali.news.news.data.api;


import com.eslamali.news.news.data.model.NewsModel.News;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiService {

    @GET("top-headlines")
    Single<News> getNewsForCountry(@Query("apiKey") String apiKey,
                                   @Query("country") String country,
                                   @Query("page") int page);

    @GET("top-headlines")
    Single<News> getNewsWithCategory(@Query("apiKey") String apiKey,
                                     @Query("country") String country,
                                     @Query("category") String category,
                                     @Query("page") int page);


}
