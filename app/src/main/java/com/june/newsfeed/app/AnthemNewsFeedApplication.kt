package com.june.newsfeed.app

import android.app.Application
import com.june.newsfeed.app.di.component.DaggerNewsFeedBaseServiceComponent
import com.june.newsfeed.app.di.component.DaggerNewsFeedDaoComponent
import com.june.newsfeed.app.di.component.NewsFeedBaseServiceComponent
import com.june.newsfeed.app.di.component.NewsFeedDaoComponent
import com.june.newsfeed.app.di.module.NewsFeedBaseServiceModule
import com.june.newsfeed.app.di.module.NewsFeedDaoModule

class AnthemNewsFeedApplication : Application() {

    private lateinit var newsFeedDaoComponent: NewsFeedDaoComponent

    private lateinit var newsFeedBaseServiceComponent: NewsFeedBaseServiceComponent


    override fun onCreate() {
        super.onCreate()

        newsFeedDaoComponent = DaggerNewsFeedDaoComponent.builder()
            .newsFeedDaoModule(NewsFeedDaoModule())
            .build()

        newsFeedBaseServiceComponent = DaggerNewsFeedBaseServiceComponent.builder()
            .newsFeedBaseServiceModule(NewsFeedBaseServiceModule(this))
            .build()
    }

    fun getNewsFeedDaoComponent(): NewsFeedDaoComponent {
        return newsFeedDaoComponent
    }

    fun getNewsFeedBaseServiceComponent(): NewsFeedBaseServiceComponent {
        return newsFeedBaseServiceComponent
    }

}