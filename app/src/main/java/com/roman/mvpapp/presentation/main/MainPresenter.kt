package com.roman.mvpapp.presentation.main

import android.util.Log
import com.github.terrakok.cicerone.Router
import com.roman.mvpapp.R
import com.roman.mvpapp.common.navigation.ScreenManager
import com.roman.mvpapp.common.providers.NetworkProvider
import com.roman.mvpapp.common.providers.ResourceProvider
import com.roman.mvpapp.domain.interactors.MainFragmentInteractor
import com.roman.mvpapp.domain.mapper.CurrencyLocalToUiMapper
import com.roman.mvpapp.presentation.model.CurrencyUi
import javax.inject.Inject
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenterScope

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

    private val errorConnection by lazy {
        resourceProvider.getString(R.string.error__no_internet_available)
    }

    override fun onFirstViewAttach() {
        loadCurrencies()
    }

    fun loadCurrencies() {
        if (networkProvider.isNetworkAvailable) {

            viewState.apply {
                getProgress(progressVisible = true)
                showError(visibility = false)
            }
            presenterScope.launch(exceptionHandler) {

                withContext(Dispatchers.IO) {
                    interactor.loadCurrencies()
                }

                interactor.subscribe()
                    .distinctUntilChanged()
                    .filter {
                        it.isNotEmpty()
                    }
                    .onEach { currencyList ->
                        val currencies = currencyList
                            .map(currencyLocalToUiMapper::map)

                        viewState.apply {
                            loadCurrencies(
                                currencies = currencies
                            )
                            getProgress(
                                progressVisible = false
                            )
                        }
                    }
                    .launchIn(scope = this)
            }.invokeOnCompletion {
                viewState.getProgress(
                    progressVisible = false
                )
            }
        } else {
            viewState.apply {
                getProgress(
                    progressVisible = false
                )
                showError(
                    visibility = true,
                    message = errorConnection
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