package com.june.newsfeed.app.di.component

import com.june.newsfeed.app.di.module.NewsFeedBaseServiceModule
import com.june.newsfeed.app.model.dao.NewsFeedDao
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NewsFeedBaseServiceModule::class])
interface NewsFeedBaseServiceComponent {
    fun injectNewsFeedBaseServiceModule(dao : NewsFeedDao)
}