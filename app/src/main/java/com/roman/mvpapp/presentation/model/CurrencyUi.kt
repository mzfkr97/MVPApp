package com.roman.mvpapp.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencyUi(
    val abbreviation: String,
    val id: Int,
    val name: String,
    val officialRate: String,
    val scale: String,
    val date: String,
    val scaleAndName: String,
) : Parcelable
