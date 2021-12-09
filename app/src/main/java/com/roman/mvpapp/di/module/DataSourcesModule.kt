package com.roman.mvpapp.di.module

import com.roman.mvpapp.data.local.LocalDataSource
import com.roman.mvpapp.data.local.LocalDataSourceImpl
import com.roman.mvpapp.data.remote.RemoteDataSource
import com.roman.mvpapp.data.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataSourcesModule {

    @Binds
    @Singleton
    fun bindsCurrenciesDataSource(impl: LocalDataSourceImpl): LocalDataSource

    @Binds
    @Singleton
    fun bindsLocalCurrencyDataSource(impl: RemoteDataSourceImpl): RemoteDataSource
}
