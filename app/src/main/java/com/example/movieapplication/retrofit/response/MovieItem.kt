package com.example.movieapplication.retrofit.response

import com.google.gson.annotations.SerializedName

data class MovieItem(
    val id: Int,
    val adult: Boolean,

    @SerializedName("backdrop_path")
    val backdropPath: String,

    @SerializedName("genre_ids")
    val genreIds: List<Int>,

    @SerializedName("original_language")
    val originalLanguage: String,

    @SerializedName("original_title")
    val originalTitle: String,

    val overview: String,
    val popularity: Double,

    @SerializedName("poster_path")
    val movieImg: String,

    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    val video: Boolean,

    @SerializedName("vote_average")
    val voteAverage: Double,

    @SerializedName("vote_count")
    val voteCount: Int,
)