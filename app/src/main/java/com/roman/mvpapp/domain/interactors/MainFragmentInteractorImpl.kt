package com.roman.mvpapp.domain.interactors

import com.roman.mvpapp.data.repositories.Repository
import com.roman.mvpapp.domain.model.CurrencyLocal
import javax.inject.Inject

interface MainFragmentInteractor {

    suspend fun loadCurrencies(): List<CurrencyLocal>
}

class MainFragmentInteractorImpl @Inject constructor(
    private val repository: Repository
) : MainFragmentInteractor {

    override suspend fun loadCurrencies() = repository.loadCurrency()
}