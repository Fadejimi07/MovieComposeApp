package com.example.movieapplication.retrofit.response

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int,
    @SerializedName("poster_path")
    val movieImg: String,
    val title: String,
)