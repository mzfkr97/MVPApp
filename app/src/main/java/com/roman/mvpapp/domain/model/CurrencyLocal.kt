package com.roman.mvpapp.domain.model

data class CurrencyLocal(
    val curAbbreviation: String,
    val curId: Int,
    val curName: String,
    val curOfficialRate: Double,
    val curScale: Int,
    val date: String,
    val scaleAndName: String,
)