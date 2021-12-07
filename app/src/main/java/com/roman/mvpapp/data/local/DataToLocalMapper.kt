package com.roman.mvpapp.data.local

import com.roman.mvpapp.data.local.model.CurrencyLocal
import com.roman.mvpapp.data.model.CurrencyData
import com.roman.mvpapp.domain.model.Currency
import javax.inject.Inject

class DataToLocalMapper @Inject constructor(){

    fun toLocal(data: CurrencyData): CurrencyLocal {
        return with(data) {
            CurrencyLocal(
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

    fun toData(data: CurrencyLocal): Currency {
        return with(data) {
            Currency(
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
}
