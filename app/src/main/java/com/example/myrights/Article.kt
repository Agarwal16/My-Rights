package com.example.myrights

import com.google.gson.annotations.SerializedName

data class Article(
    val title: String,
    val description: String,
    @SerializedName("urlToImage")
    val imageUrl: String
    // other properties you need from the API response
)
