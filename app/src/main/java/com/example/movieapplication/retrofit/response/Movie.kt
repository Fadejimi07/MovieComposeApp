package com.example.movieapplication.retrofit.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies_table")
data class Movie(
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    @SerializedName("poster_path")
    val movieImg: String,
    val title: String,
    @SerializedName("overview")
    val body: String,
)