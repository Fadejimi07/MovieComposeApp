package com.example.movieapplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieapplication.retrofit.response.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MoviesDB : RoomDatabase() {
    // DAO
    abstract val movieDao: MovieDao

    //Singleton design pattern
    companion object {
        @Volatile
        private var INSTANCE: MoviesDB? = null

        fun getInstance(context: Context): MoviesDB {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    // creating the DB object
                    instance = Room.databaseBuilder(
                        context = context.applicationContext,
                        MoviesDB::class.java,
                        "movies_db"
                    ).build()
                }

                return instance
            }
        }
    }
}