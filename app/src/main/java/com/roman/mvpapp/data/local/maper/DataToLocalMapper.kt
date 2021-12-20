package com.roman.mvpapp.data.local.maper

import com.roman.mvpapp.data.local.entity.CurrencyLocal
import com.roman.mvpapp.data.model.CurrencyData
import com.roman.mvpapp.domain.model.Currency
import javax.inject.Inject

class DataToLocalMapper @Inject constructor() {

    fun toLocal(data: CurrencyData) = with(data) {
        CurrencyLocal(
            abbreviation = abbreviation,
            id = id,
            name = name,
            officialRate = officialRate,
            curScale = curScale,
            date = date,
            scaleAndName = "$curScale $name"
        )
    }

    fun toData(data: CurrencyLocal) = with(data) {
        Currency(
            abbreviation = abbreviation,
            id = id,
            name = name,
            officialRate = officialRate,
            curScale = curScale,
            date = date,
            scaleAndName = "$curScale $name"
        )
    }
}
