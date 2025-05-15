package com.example.robokalam.Respository

import androidx.lifecycle.LiveData
import com.example.robokalam.Dao.PortfolioDao
import com.example.robokalam.Model.Portfolio

class PortfolioRepository(private val portfolioDao : PortfolioDao) {

  val getAllPortfolio : LiveData<List<Portfolio>> = portfolioDao.getAllPortfolio()

  suspend  fun insert(portfolio: Portfolio) = portfolioDao.insert(portfolio)
    suspend fun update(portfolio: Portfolio) =  portfolioDao.update(portfolio)
    suspend fun delete(portfolio: Portfolio) = portfolioDao.delete(portfolio)


}