package com.roman.mvpapp.di.module

import com.roman.mvpapp.domain.interactors.MainFragmentInteractor
import com.roman.mvpapp.domain.interactors.MainFragmentInteractorImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface InteractorsModule {

    @Binds
    @Singleton
    fun provideMainFragmentInteractor(impl: MainFragmentInteractorImpl): MainFragmentInteractor
}