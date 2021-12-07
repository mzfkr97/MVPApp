package com.roman.mvpapp.common.providers

import android.content.Context
import com.roman.mvpapp.common.extension.isNetworkAvailable
import javax.inject.Inject

interface NetworkProvider {

    val isNetworkAvailable: Boolean

    fun isNetworkAvailable(failBlock: () -> Unit, successBlock: () -> Unit)
}

class NetworkProviderImpl @Inject constructor(
    private val context: Context
) : NetworkProvider {

    override val isNetworkAvailable: Boolean
        get() = context.isNetworkAvailable()

    override fun isNetworkAvailable(failBlock: () -> Unit, successBlock: () -> Unit) {
        context.isNetworkAvailable(failBlock, successBlock)
    }
}
