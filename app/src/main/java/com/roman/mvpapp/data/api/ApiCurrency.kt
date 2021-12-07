package com.roman.mvpapp.data.api

import com.roman.mvpapp.data.model.CurrencyRemote
import retrofit2.http.GET

/**
 * Params here: http://www.nbrb.by/apihelp/exrates
 */
interface ApiCurrency {

    @GET("/api/exrates/rates?periodicity=0")
    suspend fun getAllCurrency(): List<CurrencyRemote>
}
