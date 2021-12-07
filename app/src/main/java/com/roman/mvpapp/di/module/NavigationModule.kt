package com.roman.mvpapp.di.module

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
class NavigationModule {

    private val cicerone: Cicerone<Router> by lazy { Cicerone.create(Router()) }

    @Provides
    fun provideFlowCicerone(): Cicerone<Router> = cicerone

    @Provides
    fun provideFlowNavigatorHolder(cicerone: Cicerone<Router>): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }

    @Provides
    fun provideFlowRouter(cicerone: Cicerone<Router>): Router {
        return cicerone.router
    }
}
