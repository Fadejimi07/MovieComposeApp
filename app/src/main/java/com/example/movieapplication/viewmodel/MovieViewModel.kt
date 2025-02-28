package com.example.movieapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapplication.BuildConfig
import com.example.movieapplication.repository.MovieRepository
import com.example.movieapplication.retrofit.response.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(val movieRepository: MovieRepository) : ViewModel() {
    var moviesFromApi by mutableStateOf<List<Movie>>(emptyList())
        private set
    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    // The offline movies
    var moviesFromDB by mutableStateOf<List<Movie>>(emptyList())
        private set
    val api_key = BuildConfig.API_KEY

    init {
        viewModelScope.launch {
            try {
                moviesFromApi =
                    movieRepository.getPopularMoviesFroOnlineApi(api_key)

                // insert Movies into ROOM db
                movieRepository.insertMoviesIntoDB(moviesFromApi)
                movies = moviesFromApi
            } catch (e: Exception) {
                // Fetch data from ROOM DB
                moviesFromDB = movieRepository.getMoviesFromDB()
                movies = moviesFromDB
            }
        }
    }
}