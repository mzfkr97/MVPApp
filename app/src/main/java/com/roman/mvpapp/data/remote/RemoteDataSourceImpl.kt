package com.roman.mvpapp.data.remote

import com.roman.mvpapp.data.mapper.CurrenciesRemoteToDataMapper
import com.roman.mvpapp.data.model.CurrencyData
import com.roman.mvpapp.data.remote.api.ApiCurrency
import javax.inject.Inject

interface RemoteDataSource {
    suspend fun getAllCurrencies(): List<CurrencyData>
}

class RemoteDataSourceImpl @Inject constructor(
    private val currencyApi: ApiCurrency,
    private val remoteToDataMapper: CurrenciesRemoteToDataMapper
) : RemoteDataSource {

    override suspend fun getAllCurrencies(): List<CurrencyData> {
        return currencyApi.getAllCurrency()
            .asSequence()
            .map(remoteToDataMapper::map)
            .filterNotNull()
            .toList()
    }
}
