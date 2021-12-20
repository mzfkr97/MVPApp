package com.roman.mvpapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currencies")
data class CurrencyLocal(
    @PrimaryKey
    val id: Int,
    val abbreviation: String,
    val name: String,
    val officialRate: Double,
    val curScale: Int,
    val date: String,
    val scaleAndName: String,
)
