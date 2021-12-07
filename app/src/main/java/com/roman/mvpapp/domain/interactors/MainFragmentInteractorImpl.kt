package com.roman.mvpapp.domain.interactors

import com.roman.mvpapp.data.repositories.Repository
import com.roman.mvpapp.domain.model.Currency
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface MainFragmentInteractor {

    fun subscribe(): Flow<List<Currency>>

    suspend fun loadCurrencies()
}

class MainFragmentInteractorImpl @Inject constructor(
    private val repository: Repository
) : MainFragmentInteractor {

    override fun subscribe(): Flow<List<Currency>> {
        return repository.allCurrencyFlow
    }

    override suspend fun loadCurrencies() {
        repository.updateCurrencies()
    }
}