package com.roman.mvpapp.presentation.details

import android.util.Log
import com.roman.mvpapp.presentation.model.CurrencyUi
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import moxy.InjectViewState
import moxy.MvpPresenter

@AssistedFactory
interface DetailsPresenterFactory {
    fun create(
        @Assisted("DetailsPresenter.currencyUi") currencyUi: CurrencyUi,
    ): DetailsPresenter
}

@InjectViewState
class DetailsPresenter @AssistedInject constructor(
    @Assisted("DetailsPresenter.currencyUi") private val currencyUi: CurrencyUi,
) : MvpPresenter<DetailsContractView>() {



    override fun onFirstViewAttach() {
        viewState.showCurrency(currencyUi)
    }

    init {
        Log.d("TAG", "currencyUi: ${ currencyUi }")
    }

}
