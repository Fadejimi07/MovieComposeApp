package com.example.movieapplication.repository

import com.example.movieapplication.retrofit.RetrofitInstance
import com.example.movieapplication.retrofit.response.MovieItem

class MovieRepository {
    // fetching data from online sources
    suspend fun getPopularMoviesFroOnlineApi(apiKey: String): List<MovieItem> {
        return RetrofitInstance.api.getPopularMovies(apiKey).results
    }
}