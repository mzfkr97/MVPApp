package com.roman.mvpapp.data.remote.api

import com.roman.mvpapp.data.remote.model.CurrencyRemote
import retrofit2.http.GET

/**
 * @params here: http://www.nbrb.by/apihelp/exrates
 */
interface ApiCurrency {

    @GET("/api/exrates/rates?periodicity=0")
    suspend fun getAllCurrency(): List<CurrencyRemote>
}