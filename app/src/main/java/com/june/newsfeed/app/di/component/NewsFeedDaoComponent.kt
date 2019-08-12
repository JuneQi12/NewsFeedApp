package com.june.newsfeed.app.di.component

import com.june.newsfeed.app.di.module.NewsFeedDaoModule
import com.june.newsfeed.app.viewModel.NewsFeedViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NewsFeedDaoModule::class])
interface NewsFeedDaoComponent {
    fun injectNewsFeedDaoModule(viewModel : NewsFeedViewModel)
}