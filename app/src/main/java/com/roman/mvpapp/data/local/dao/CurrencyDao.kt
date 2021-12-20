package com.roman.mvpapp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.roman.mvpapp.data.local.entity.CurrencyLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao : BaseDao<CurrencyLocal> {

    @Query("SELECT * FROM currencies ORDER BY name ASC")
    fun getAllCurrency(): Flow<List<CurrencyLocal>>
}
