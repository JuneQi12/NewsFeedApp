package com.june.newsfeed.app.di.module

import com.june.newsfeed.app.model.dao.NewsFeedDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class NewsFeedDaoModule {

    @Provides
    @Singleton
    fun  provideDao() : NewsFeedDao {
        return NewsFeedDao()
    }
}