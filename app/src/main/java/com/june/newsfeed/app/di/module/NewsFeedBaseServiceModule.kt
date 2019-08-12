package com.june.newsfeed.app.di.module

import android.app.Application
import com.june.newsfeed.app.R
import com.june.newsfeed.app.model.networkLayer.NewsFeedService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NewsFeedBaseServiceModule(application: Application) {


    private var baseURL: String = application.getString(R.string.base_url)
    private var builder: Retrofit.Builder

    init {
        builder = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(MoshiConverterFactory.create())

    }


    @Provides
    @Singleton
    fun createService(): NewsFeedService {
        val retrofit = builder.build()
        return retrofit.create(NewsFeedService::class.java)
    }


}