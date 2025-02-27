package com.example.movieapplication.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.movieapplication.retrofit.response.Movie

@Composable
fun MovieItem(movie: Movie) {
    Card(
        elevation = CardDefaults.cardElevation(6.dp),
        border = BorderStroke(width = 4.dp, brush = Brush.linearGradient()),
        colors = CardDefaults.cardColors().copy(
            containerColor = Color.Gray
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(4.dp)
        ) {
            AsyncImage(
                model = movie.movieImg,
                contentDescription = movie.title,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 2.dp, end = 8.dp),
                contentScale = ContentScale.FillHeight
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = movie.title,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = movie.body,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}