package com.roman.mvpapp.data.mapper

import com.roman.mvpapp.data.model.CurrencyRemote
import com.roman.mvpapp.domain.model.CurrencyLocal
import javax.inject.Inject

class CurrenciesRemoteToLocalMapper @Inject constructor() {

    fun map(data: CurrencyRemote): CurrencyLocal {
        return with(data) {
            CurrencyLocal(
                curAbbreviation = abbreviation,
                curId = curId,
                curName = curName,
                curOfficialRate = officialRate,
                curScale = curScale,
                date = date,
                scaleAndName = "$curScale $curName"
            )
        }
    }
}
