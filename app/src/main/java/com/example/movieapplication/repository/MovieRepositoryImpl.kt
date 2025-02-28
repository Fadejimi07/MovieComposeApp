package com.example.movieapplication.repository

import com.example.movieapplication.BuildConfig
import com.example.movieapplication.retrofit.ApiService
import com.example.movieapplication.retrofit.response.Movie
import com.example.movieapplication.room.MovieDao

class MovieRepositoryImpl(private val movieDao: MovieDao, private val apiService: ApiService) :
    MovieRepository {
    override suspend fun getPopularMoviesFroOnlineApi(apiKey: String): List<Movie> {
        return apiService.getPopularMovies(BuildConfig.API_KEY).results
    }

    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getAllMoviesInDB()
    }

    override suspend fun insertMoviesIntoDB(movies: List<Movie>) {
        movieDao.insertMoviesList(movies)
    }

    override suspend fun insertSingleMovieIntoDB(movie: Movie) {
        movieDao.insert(movie)
    }
}