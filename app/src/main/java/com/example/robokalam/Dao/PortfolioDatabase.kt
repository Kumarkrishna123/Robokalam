package com.example.robokalam.Dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.robokalam.Model.Portfolio

@Database(entities = [Portfolio::class] , version =1 )
abstract class PortfolioDatabase : RoomDatabase(){

    abstract fun portfolioDao(): PortfolioDao

    companion object{
        @Volatile
        private var INSTANCE : PortfolioDatabase?= null

        fun getDatabase(context: Context) : PortfolioDatabase{
            if(INSTANCE == null){
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context ,
                        PortfolioDatabase::class.java,
                        "PortfolioDB"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }


}



