package com.example.movieapplication.di

import android.content.Context
import androidx.room.Room
import com.example.movieapplication.room.MovieDao
import com.example.movieapplication.room.MoviesDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomDatabaseModule {
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): MoviesDB {
        return Room.databaseBuilder(
            context = context,
            MoviesDB::class.java,
            "movies_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesMovieDao(moviesDB: MoviesDB): MovieDao {
        return moviesDB.movieDao
    }
}