package com.example.movieapplication.repository

import android.content.Context
import com.example.movieapplication.retrofit.RetrofitInstance
import com.example.movieapplication.retrofit.response.Movie
import com.example.movieapplication.room.MovieDao
import com.example.movieapplication.room.MoviesDB

class MovieRepository(context: Context) {
    // fetching data from online sources
    suspend fun getPopularMoviesFroOnlineApi(apiKey: String): List<Movie> {
        return RetrofitInstance.api.getPopularMovies(apiKey).results
    }

    // Fetching data from offline room db
    private val db = MoviesDB.getInstance(context = context)
    private val movieDao: MovieDao = db.movieDao

    suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getAllMoviesInDB()
    }

    suspend fun insertMoviesIntoDB(movies: List<Movie>) {
        return movieDao.insertMoviesList(movies)
    }

    suspend fun insertSingleMovieIntoDB(movie: Movie) {
        return movieDao.insert(movie)
    }
}