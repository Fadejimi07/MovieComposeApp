package com.example.movieapplication.retrofit.response

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int,
    @SerializedName("poster_path")
    val movieImg: String,
    val title: String,
    @SerializedName("overview")
    val body: String,
) {
    val imageUrl = "https://image.tmdb.org/t/p/w500/$movieImg"
}