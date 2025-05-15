package com.example.robokalam.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrfitInstance {
    private const val BASE_URL = "https://zenquotes.io/api/"

    val api : QuuoteApiSevice by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuuoteApiSevice::class.java)
    }
}