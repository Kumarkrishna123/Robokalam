package com.example.robokalam.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.robokalam.Model.Portfolio

@Dao
interface PortfolioDao {

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insert(portfolio: Portfolio)

    @Update
    suspend fun update(portfolio: Portfolio)

    @Delete
    suspend fun delete(portfolio: Portfolio)

    @Query("SELECT * FROM portfolio")
     fun getAllPortfolio() : LiveData<List<Portfolio>>



}