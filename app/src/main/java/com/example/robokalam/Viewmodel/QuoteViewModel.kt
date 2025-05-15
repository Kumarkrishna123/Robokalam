package com.example.robokalam.Viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.robokalam.Model.QuoteItem
import com.example.robokalam.Respository.QuoteRepository
import kotlinx.coroutines.launch
import java.util.Date
import java.text.SimpleDateFormat
import java.util.Locale

class QuoteViewModel(application: Application): AndroidViewModel(application) {

    private val repository = QuoteRepository()

    private val _quote = MutableLiveData<QuoteItem>()
    val quote: LiveData<QuoteItem> get() = _quote

    fun getQuoteIfNeeded(){
        val sharedPreferences =  getApplication<Application>().getSharedPreferences("QuotePrefs",
            Context.MODE_PRIVATE)
        val lastFetchDate = sharedPreferences.getString("lastDate" , "")
        val today = SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()).format(Date())

        if(today != lastFetchDate){
            viewModelScope.launch {

                val result =  repository.getQuote()
                result?.let {
                    _quote.postValue(it)

                    sharedPreferences.edit().putString("lastDate" , today).apply()
                }

            }


        }

    }




}