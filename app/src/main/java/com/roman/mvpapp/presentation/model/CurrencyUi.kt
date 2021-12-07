package com.roman.mvpapp.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencyUi(
    val curAbbreviation: String,
    val curId: Int,
    val curName: String,
    val curOfficialRate: String,
    val curScale: String,
    val date: String,
    val scaleAndName: String,
) : Parcelable
