package com.roman.mvpapp.data.repositories

import com.roman.mvpapp.data.local.LocalDataSource
import com.roman.mvpapp.data.remote.RemoteDataSource
import com.roman.mvpapp.domain.model.Currency
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

interface Repository {

    val allCurrencyFlow: Flow<List<Currency>>

    suspend fun updateCurrencies()
}

class BankRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : Repository {

    override val allCurrencyFlow
        get() = localDataSource.allCurrencyFlow

    override suspend fun updateCurrencies() {
        val currencies = remoteDataSource.getAllCurrencies()
        localDataSource.updateCurrencies(currencies)
    }
}
