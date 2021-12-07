package com.roman.mvpapp.di.module

import com.roman.mvpapp.common.providers.NetworkProvider
import com.roman.mvpapp.common.providers.NetworkProviderImpl
import com.roman.mvpapp.common.providers.ResourceProvider
import com.roman.mvpapp.common.providers.ResourceProviderImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ToolsModule {

    @Binds
    @Singleton
    fun bindsResourceProvider(impl: ResourceProviderImpl): ResourceProvider

    @Binds
    @Singleton
    fun bindsNetworkProvider(impl: NetworkProviderImpl): NetworkProvider
}