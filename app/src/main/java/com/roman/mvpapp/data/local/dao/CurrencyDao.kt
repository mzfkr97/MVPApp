package com.roman.mvpapp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.roman.mvpapp.data.local.model.CurrencyLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao : BaseDao<CurrencyLocal> {

    @Query("SELECT * FROM currencies ORDER BY curName ASC")
    fun getAllCurrency(): Flow<List<CurrencyLocal>>
}