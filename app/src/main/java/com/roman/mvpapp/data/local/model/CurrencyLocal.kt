package com.roman.mvpapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currencies")
data class CurrencyLocal(
    @PrimaryKey
    val curId: Int,
    val abbreviation: String,
    val curName: String,
    val officialRate: Double,
    val curScale: Int,
    val date: String,
    val scaleAndName: String,
)