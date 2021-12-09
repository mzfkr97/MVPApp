package com.roman.mvpapp.di.module

import android.content.Context
import androidx.room.Room
import com.roman.mvpapp.data.local.CurrenciesDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideDataBase(context: Context) = Room.databaseBuilder(
        context.applicationContext,
        CurrenciesDb::class.java,
        "currencies.db"
    ).build()

    @Singleton
    @Provides
    fun provideDAO(db: CurrenciesDb) = db.currencyDao()
}
