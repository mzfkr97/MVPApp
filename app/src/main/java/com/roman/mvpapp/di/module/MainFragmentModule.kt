package com.roman.mvpapp.di.module

import com.github.terrakok.cicerone.Router
import com.roman.mvpapp.common.providers.NetworkProvider
import com.roman.mvpapp.common.providers.ResourceProvider
import com.roman.mvpapp.domain.interactors.MainFragmentInteractor
import com.roman.mvpapp.domain.mapper.CurrencyLocalToUiMapper
import com.roman.mvpapp.presentation.activity.MainPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainFragmentModule {

    @Provides
    @Singleton
    fun provideMainFragmentPresenter(
        currencyLocalToUiMapper: CurrencyLocalToUiMapper,
        appRouter: Router,
        interactor: MainFragmentInteractor,
        networkProvider: NetworkProvider,
        resourceProvider: ResourceProvider
    ) = MainPresenter(
        currencyLocalToUiMapper = currencyLocalToUiMapper,
        appRouter = appRouter,
        interactor = interactor,
        networkProvider = networkProvider,
        resourceProvider = resourceProvider
    )
}