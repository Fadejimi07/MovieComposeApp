package com.example.movieapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapplication.repository.MovieRepository
import com.example.movieapplication.retrofit.response.MovieItem
import kotlinx.coroutines.launch

class MovieViewModel(val movieRepository: MovieRepository) : ViewModel() {
    var moviesFromApi by mutableStateOf<List<MovieItem>>(emptyList())
        private set
    var movies by mutableStateOf<List<MovieItem>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            val movieItems =
                movieRepository.getPopularMoviesFroOnlineApi("5dd5f72a8582886decaf7c52f0ad6080")
            moviesFromApi = movieItems
        }
    }
}