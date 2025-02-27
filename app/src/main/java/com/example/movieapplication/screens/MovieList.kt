package com.example.movieapplication.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movieapplication.viewmodel.MovieViewModel

@Composable
fun MovieList(viewModel: MovieViewModel, modifier: Modifier) {
    val movies = viewModel.movies

    LazyColumn(modifier = modifier) {
        items(movies) { movie ->
            MovieItem(movie)
        }
    }
}