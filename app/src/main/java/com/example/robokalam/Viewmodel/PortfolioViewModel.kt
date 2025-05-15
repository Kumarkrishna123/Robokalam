package com.example.robokalam.Viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.robokalam.Dao.PortfolioDatabase
import com.example.robokalam.Model.Portfolio
import com.example.robokalam.Respository.PortfolioRepository
import kotlinx.coroutines.launch

class PortfolioViewModel(application : Application) : AndroidViewModel(application) {

    private val repo  : PortfolioRepository

    val getAllPortfolio : LiveData<List<Portfolio>>


    init {
        val dao = PortfolioDatabase.getDatabase(application).portfolioDao()
        repo = PortfolioRepository(dao)
        getAllPortfolio = repo.getAllPortfolio
    }


    fun insert(portfolio: Portfolio) {
        viewModelScope.launch {
            repo.insert(portfolio)
        }
    }

    fun update(portfolio: Portfolio) {
        viewModelScope.launch {
            repo.update(portfolio)
        }
    }
    fun delete(portfolio: Portfolio) {
        viewModelScope.launch {
            repo.delete(portfolio)
        }
    }

}