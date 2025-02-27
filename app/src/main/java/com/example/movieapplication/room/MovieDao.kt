package com.example.movieapplication.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.movieapplication.retrofit.response.Movie

@Dao
interface MovieDao {
    @Insert
    suspend fun insert(movie: Movie)

    @Insert
    suspend fun insertMoviesList(movies: List<Movie>)

    @Query("SELECT * FROM movies_table")
    suspend fun getAllMoviesInDB(): List<Movie>
}