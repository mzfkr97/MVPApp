package com.roman.mvpapp.domain.model

data class Currency(
    val curId: Int,
    val abbreviation: String,
    val curName: String,
    val officialRate: Double,
    val curScale: Int,
    val date: String,
    val scaleAndName: String,
)
