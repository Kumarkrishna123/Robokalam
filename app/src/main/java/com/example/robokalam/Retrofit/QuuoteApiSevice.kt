package com.example.robokalam.Retrofit

import com.example.robokalam.Model.QuoteItem
import retrofit2.http.GET

interface QuuoteApiSevice {
    @GET("today")
    suspend fun getQuoteOfTheDay() : List<QuoteItem>
}