package com.roman.mvpapp.presentation.mapper

import com.roman.mvpapp.domain.model.Currency
import com.roman.mvpapp.presentation.model.CurrencyUi
import javax.inject.Inject

class CurrencyLocalToUiMapper @Inject constructor() {

    fun map(model: Currency) = with(model) {
        CurrencyUi(
            abbreviation = abbreviation,
            id = id,
            name = name,
            officialRate = officialRate.toString(),
            scale = curScale.toString(),
            date = date,
            scaleAndName = scaleAndName,
        )
    }
}
