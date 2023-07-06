package com.example.myrights

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
    // other properties you need from the API response
)
