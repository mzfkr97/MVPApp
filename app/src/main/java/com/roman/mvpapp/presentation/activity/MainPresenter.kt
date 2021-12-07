package com.roman.mvpapp.presentation.activity

import com.github.terrakok.cicerone.Router
import com.roman.mvpapp.R
import com.roman.mvpapp.common.navigation.ScreenManager
import com.roman.mvpapp.common.providers.NetworkProvider
import com.roman.mvpapp.common.providers.ResourceProvider
import com.roman.mvpapp.domain.interactors.MainFragmentInteractor
import com.roman.mvpapp.domain.mapper.CurrencyLocalToUiMapper
import com.roman.mvpapp.presentation.MainContractView
import com.roman.mvpapp.presentation.main.model.CurrencyUi
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
    private val currencyLocalToUiMapper: CurrencyLocalToUiMapper,
    private val appRouter: Router,
    private val interactor: MainFragmentInteractor,
    private val networkProvider: NetworkProvider,
    private val resourceProvider: ResourceProvider,
) : MvpPresenter<MainContractView>() {

    private val exceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            viewState.showToast(throwable.message.toString())
        }

    private val checkConnectionMessage by lazy {
        resourceProvider.getString(R.string.error__no_internet_available)
    }

    init {
        loadCurrencies()
    }

    fun loadCurrencies() {
        if (networkProvider.isNetworkAvailable) {

            viewState.apply {
                getProgress(progressVisible = true)
                showError(visibility = false)
            }
            presenterScope.launch(exceptionHandler) {
                val currencies = withContext(Dispatchers.IO) {
                    interactor.loadCurrencies()
                        .map(
                            currencyLocalToUiMapper::map
                        )
                }
                viewState.apply {
                    loadCurrencies(currencies = currencies)
                    getProgress(progressVisible = false)
                }
            }.invokeOnCompletion {
                viewState. getProgress(progressVisible = false)
            }
        } else {
            viewState.apply {
                getProgress(progressVisible = false)
                showError(
                    visibility = true,
                    message = checkConnectionMessage
                )
            }
        }
    }

    fun toDetailScreen(item: CurrencyUi) {
        appRouter.navigateTo(
            ScreenManager.ToDetailsFragment(item)
        )
    }
}
