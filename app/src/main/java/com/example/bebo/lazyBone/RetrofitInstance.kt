package com.example.bebo.lazyBone

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// use object instead of using class to make sure there's only one instance can be created
// and decrease the memory usage
object RetrofitInstance {
    private const val BASE_URL = "https://exercisedb.p.rapidapi.com/"
    val api: ExerciseApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // convert JSON into Kotlin data classes
            .build()
            .create(ExerciseApiService::class.java)
    }
}