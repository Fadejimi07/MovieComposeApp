package com.example.movieapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.movieapplication.repository.MovieRepository
import com.example.movieapplication.screens.MovieList
import com.example.movieapplication.ui.theme.MovieApplicationTheme
import com.example.movieapplication.viewmodel.MovieViewModel
import com.example.movieapplication.viewmodel.ViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val viewModelFactory = ViewModelFactory(MovieRepository())
        val viewModel = ViewModelProvider(this, viewModelFactory)[MovieViewModel::class.java]
        setContent {
            MovieApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MovieList(viewModel = viewModel, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}