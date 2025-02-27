package com.example.movieapplication.retrofit

import retrofit2.Retrofit

object RetrofitInstance {
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    val api: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
}