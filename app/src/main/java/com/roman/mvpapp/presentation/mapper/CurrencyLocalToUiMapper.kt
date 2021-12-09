package com.roman.mvpapp.presentation.mapper

import com.roman.mvpapp.domain.model.Currency
import com.roman.mvpapp.presentation.model.CurrencyUi
import javax.inject.Inject

class CurrencyLocalToUiMapper @Inject constructor() {

    fun map(model: Currency) = with(model) {
        CurrencyUi(
            curAbbreviation = abbreviation,
            curId = curId,
            curName = curName,
            curOfficialRate = officialRate.toString(),
            curScale = curScale.toString(),
            date = date,
            scaleAndName = scaleAndName,
        )
    }
}
