package com.roman.mvpapp.domain

import com.roman.mvpapp.domain.model.Currency
import kotlinx.coroutines.flow.Flow

interface MainFragmentInteractor {

    fun subscribe(): Flow<List<Currency>>

    suspend fun loadCurrencies()
}