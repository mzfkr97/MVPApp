package com.roman.mvpapp.data.local

import com.roman.mvpapp.data.local.dao.CurrencyDao
import com.roman.mvpapp.data.local.maper.DataToLocalMapper
import com.roman.mvpapp.data.model.CurrencyData
import com.roman.mvpapp.domain.model.Currency
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface LocalDataSource {

    val allCurrencyFlow: Flow<List<Currency>>

    suspend fun updateCurrencies(currencies: List<CurrencyData>)
}

class LocalDataSourceImpl @Inject constructor(
    private val dao: CurrencyDao,
    private val dataToLocalMapper: DataToLocalMapper,
) : LocalDataSource {

    override val allCurrencyFlow: Flow<List<Currency>>
        get() = dao.getAllCurrency()
            .map { currency ->
                currency.map(dataToLocalMapper::toData)
            }

    override suspend fun updateCurrencies(currencies: List<CurrencyData>) {
        val entities = currencies.map(
            dataToLocalMapper::toLocal
        )
        dao.insertList(entities)
    }
}