package com.roman.mvpapp.data.model

data class CurrencyData(
    val curId: Int,
    val abbreviation: String,
    val curName: String,
    val officialRate: Double,
    val curScale: Int,
    val date: String,
    val scaleAndName: String,
)
