package com.june.newsfeed.app.model.data

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)