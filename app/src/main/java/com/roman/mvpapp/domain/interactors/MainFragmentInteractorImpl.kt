package com.roman.mvpapp.domain.interactors

import com.roman.mvpapp.domain.MainFragmentInteractor
import com.roman.mvpapp.domain.Repository
import javax.inject.Inject

class MainFragmentInteractorImpl @Inject constructor(
    private val repository: Repository
) : MainFragmentInteractor {

    override fun subscribe() = repository.allCurrencyFlow

    override suspend fun loadCurrencies() {
        repository.updateCurrencies()
    }
}
