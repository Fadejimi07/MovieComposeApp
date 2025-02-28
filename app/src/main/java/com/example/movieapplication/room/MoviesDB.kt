package com.example.movieapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapplication.retrofit.response.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MoviesDB : RoomDatabase() {
    // DAO
    abstract val movieDao: MovieDao
}