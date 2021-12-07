package com.roman.mvpapp.presentation.main.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencyUi(
    val curAbbreviation: String,
    val curId: Int,
    val curName: String,
    val curOfficialRate: Double,
    val curScale: String,
    val date: String,
    val scaleAndName: String,
) : Parcelable
