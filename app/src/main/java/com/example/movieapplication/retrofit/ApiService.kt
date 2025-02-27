package com.example.movieapplication.retrofit

import com.example.movieapplication.retrofit.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")
        apiKey: String
    ): MovieResponse
}