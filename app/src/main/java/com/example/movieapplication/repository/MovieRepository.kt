package com.example.movieapplication.repository

import com.example.movieapplication.retrofit.response.Movie

interface MovieRepository {
    // fetching data from online sources
    suspend fun getPopularMoviesFroOnlineApi(apiKey: String): List<Movie>

    suspend fun getMoviesFromDB(): List<Movie>

    suspend fun insertMoviesIntoDB(movies: List<Movie>)

    suspend fun insertSingleMovieIntoDB(movie: Movie)
}