package com.roman.mvpapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class CurrencyRemote(
    @SerializedName("Cur_Abbreviation")
    val abbreviation: String,
    @SerializedName("Cur_ID")
    val curId: Int,
    @SerializedName("Cur_Name")
    val curName: String,
    @SerializedName("Cur_OfficialRate")
    val officialRate: Double,
    @SerializedName("Cur_Scale")
    val curScale: Int,
    @SerializedName("Date")
    val date: String,
)