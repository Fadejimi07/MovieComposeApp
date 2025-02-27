package com.example.movieapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapplication.repository.MovieRepository
import com.example.movieapplication.retrofit.response.Movie
import kotlinx.coroutines.launch

class MovieViewModel(val movieRepository: MovieRepository) : ViewModel() {
    var moviesFromApi by mutableStateOf<List<Movie>>(emptyList())
        private set
    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            try {
                moviesFromApi =
                    movieRepository.getPopularMoviesFroOnlineApi("5dd5f72a8582886decaf7c52f0ad6080")
                movies = moviesFromApi
            } catch (e: Exception) {
                // Fetch data from ROOM DB
            }
        }
    }
}