package com.roman.mvpapp.common.extension

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

@SuppressLint("MissingPermission")
fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val network = connectivityManager.activeNetwork
    val capabilities = connectivityManager.getNetworkCapabilities(network)
    return capabilities != null && (
        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
            capabilities.hasTransport(
                NetworkCapabilities.TRANSPORT_CELLULAR
            )
        )
}

fun Context.isNetworkAvailable(failBlock: () -> Unit, successBlock: () -> Unit) {
    if (this.isNetworkAvailable()) {
        successBlock()
    } else {
        failBlock()
    }
}
