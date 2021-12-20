package com.roman.mvpapp.domain

import com.roman.mvpapp.domain.model.Currency
import kotlinx.coroutines.flow.Flow

interface Repository {

    val allCurrencyFlow: Flow<List<Currency>>

    suspend fun updateCurrencies()
}