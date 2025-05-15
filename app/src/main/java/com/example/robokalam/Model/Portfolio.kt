package com.example.robokalam.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "portfolio")
data class Portfolio(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val collage :String,
    val skill : String,
    val projectTittle : String,
    val description : String,
)
