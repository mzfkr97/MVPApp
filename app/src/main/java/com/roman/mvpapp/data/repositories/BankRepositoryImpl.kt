package com.roman.mvpapp.data.repositories

import com.roman.mvpapp.data.local.LocalDataSource
import com.roman.mvpapp.data.remote.RemoteDataSource
import com.roman.mvpapp.domain.Repository
import javax.inject.Inject

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
