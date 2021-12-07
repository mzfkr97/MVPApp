package com.roman.mvpapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.roman.mvpapp.data.local.dao.CurrencyDao
import com.roman.mvpapp.data.local.model.CurrencyLocal

@Database(
    entities = [CurrencyLocal::class],
    version = 1,
    exportSchema = false
)
abstract class CurrenciesDb : RoomDatabase() {

    abstract fun currencyDao(): CurrencyDao
}
