package com.june.newsfeed.app.model.dao

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.june.newsfeed.app.AnthemNewsFeedApplication
import com.june.newsfeed.app.model.data.News
import com.june.newsfeed.app.model.networkLayer.NewsFeedService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NewsFeedDao {

    @Inject
    lateinit var newsFeedService: NewsFeedService

    fun retrieveNewsFeed(endPoint : String, country : String, category : String, API_KEY : String, application: Application) : LiveData<News>{

        (application as AnthemNewsFeedApplication).getNewsFeedBaseServiceComponent().injectNewsFeedBaseServiceModule(this)
        val newsFeed : MutableLiveData<News> = MutableLiveData()
       val call = newsFeedService.retrieveNewsFeed(endPoint, country, category, API_KEY)
        call.enqueue(object : Callback<News>{
            override fun onFailure(call: Call<News>, t: Throwable) {
                newsFeed.value = null
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
            newsFeed.value = response.body()
            }

        })

        return newsFeed
    }
}