package com.roman.mvpapp.data.model

data class CurrencyData(
    val id: Int,
    val abbreviation: String,
    val name: String,
    val officialRate: Double,
    val curScale: Int,
    val date: String,
    val scaleAndName: String,
)
