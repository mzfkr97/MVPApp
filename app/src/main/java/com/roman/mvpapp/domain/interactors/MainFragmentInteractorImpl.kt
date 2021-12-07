package com.roman.mvpapp.domain.interactors

import com.roman.mvpapp.data.repositories.Repository
import com.roman.mvpapp.domain.model.Currency
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

interface MainFragmentInteractor {

    fun subscribe(): Flow<List<Currency>>

    suspend fun loadCurrencies()
}

class MainFragmentInteractorImpl @Inject constructor(
    private val repository: Repository
) : MainFragmentInteractor {

    override fun subscribe() = repository.allCurrencyFlow

    override suspend fun loadCurrencies() {
        repository.updateCurrencies()
    }
}