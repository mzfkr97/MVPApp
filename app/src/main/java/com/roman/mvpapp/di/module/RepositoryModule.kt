package com.roman.mvpapp.di.module

import com.roman.mvpapp.data.repositories.BankRepositoryImpl
import com.roman.mvpapp.data.repositories.Repository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsBankRepository(impl: BankRepositoryImpl): Repository
}
