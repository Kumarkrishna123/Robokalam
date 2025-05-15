package com.example.robokalam.Respository

import com.example.robokalam.Model.QuoteItem
import com.example.robokalam.Retrofit.RetrfitInstance

class QuoteRepository {
    suspend fun getQuote() : QuoteItem? {
        return try {
            RetrfitInstance.api.getQuoteOfTheDay().firstOrNull()
        }
        catch (e : Exception){
             null
        }
    }
}