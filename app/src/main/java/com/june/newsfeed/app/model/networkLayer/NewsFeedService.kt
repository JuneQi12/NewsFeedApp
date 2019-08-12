package com.june.newsfeed.app.model.networkLayer

import com.june.newsfeed.app.model.data.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface NewsFeedService{

    @GET
    fun retrieveNewsFeed(
        @Url endPoint : String,
        @Query("country") country : String,
        @Query("category") category: String,
        @Query("apiKey") API_KEY : String) : Call<News>
}