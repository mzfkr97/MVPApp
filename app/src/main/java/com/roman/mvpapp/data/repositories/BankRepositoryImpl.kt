package com.roman.mvpapp.data.repositories

import com.roman.mvpapp.data.api.ApiCurrency
import com.roman.mvpapp.data.mapper.CurrenciesRemoteToLocalMapper
import com.roman.mvpapp.domain.model.CurrencyLocal
import javax.inject.Inject

interface Repository {

    suspend fun loadCurrency(): List<CurrencyLocal>
}

class BankRepositoryImpl @Inject constructor(
    private val currencyApi: ApiCurrency,
    private val remoteToLocalMapper: CurrenciesRemoteToLocalMapper
) : Repository {

    override suspend fun loadCurrency(): List<CurrencyLocal> {
        return currencyApi.getAllCurrency()
            .asSequence()
            .map(
                remoteToLocalMapper::map
            )
            .filterNotNull()
            .toList()
    }
}
