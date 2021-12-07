package com.roman.mvpapp.data.mapper

import com.roman.mvpapp.data.model.CurrencyData
import com.roman.mvpapp.data.remote.model.CurrencyRemote
import javax.inject.Inject

class CurrenciesRemoteToDataMapper @Inject constructor() {

    fun map(data: CurrencyRemote) = with(data) {
        CurrencyData(
            abbreviation = abbreviation,
            curId = curId,
            curName = curName,
            officialRate = officialRate,
            curScale = curScale,
            date = date,
            scaleAndName = "$curScale $curName"
        )
    }
}