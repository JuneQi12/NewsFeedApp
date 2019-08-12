package com.june.newsfeed.app.viewModel

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.june.newsfeed.app.AnthemNewsFeedApplication
import com.june.newsfeed.app.model.dao.NewsFeedDao
import com.june.newsfeed.app.model.data.Article
import com.june.newsfeed.app.model.data.News
import javax.inject.Inject

class NewsFeedViewModel : ViewModel() {

    lateinit var newsFeedLiveData: LiveData<News>

    @Inject
    lateinit var newsFeedDao: NewsFeedDao


    fun retrieveNewsFeed(endPoint: String, country: String, category: String, API_KEY: String, application: Application): LiveData<News> {
        (application as AnthemNewsFeedApplication).getNewsFeedDaoComponent().injectNewsFeedDaoModule(this)
        newsFeedLiveData = newsFeedDao.retrieveNewsFeed(endPoint, country, category, API_KEY, application)
        return newsFeedLiveData
    }

    fun getArticleAtIndex(position: Int?) : Article?{
        return when {
            newsFeedLiveData.value?.articles == null -> null
            newsFeedLiveData.value?.articles?.size!! > position!! -> newsFeedLiveData.value?.articles!![position]
            else -> null
        }
    }



    fun getWebViewUrl(position: Int): String? {
        return if (newsFeedLiveData.value?.articles?.size!! > position)

         newsFeedLiveData.value?.articles!![position].url
        else
            null
    }

}