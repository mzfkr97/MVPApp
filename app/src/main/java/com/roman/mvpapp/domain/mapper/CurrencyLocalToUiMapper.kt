package com.roman.mvpapp.domain.mapper

import com.roman.mvpapp.domain.model.CurrencyLocal
import com.roman.mvpapp.presentation.main.model.CurrencyUi
import javax.inject.Inject

class CurrencyLocalToUiMapper @Inject constructor() {

    fun map(model: CurrencyLocal) = with(model) {
        CurrencyUi(
            curAbbreviation = curAbbreviation,
            curId = curId,
            curName = curName,
            curOfficialRate = curOfficialRate,
            curScale = curScale.toString(),
            date = date,
            scaleAndName = scaleAndName,
        )
    }
}
