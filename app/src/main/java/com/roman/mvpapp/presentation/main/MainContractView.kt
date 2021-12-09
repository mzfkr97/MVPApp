package com.roman.mvpapp.presentation.main

import com.roman.mvpapp.common.extension.EMPTY_STRING
import com.roman.mvpapp.presentation.model.CurrencyUi
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface MainContractView : MvpView {

    @AddToEndSingle
    fun loadCurrencies(currencies: List<CurrencyUi>)

    @AddToEndSingle
    fun getProgress(progressVisible: Boolean = false)

    @AddToEndSingle
    fun showToast(message: String)

    @AddToEndSingle
    fun showError(
        visibility: Boolean,
        message: String = EMPTY_STRING
    )

    @Skip
    fun errorAction()
}
