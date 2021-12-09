package com.roman.mvpapp.presentation.details

import com.roman.mvpapp.presentation.model.CurrencyUi
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface DetailsContractView : MvpView {

    @AddToEndSingle
    fun showCurrency(currencies: CurrencyUi)

    @Skip
    fun errorAction()
}