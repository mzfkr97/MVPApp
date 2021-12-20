package com.roman.mvpapp.domain.model

data class Currency(
    val id: Int,
    val abbreviation: String,
    val name: String,
    val officialRate: Double,
    val curScale: Int,
    val date: String,
    val scaleAndName: String,
)
