package com.roman.mvpapp.common

sealed class AppException(reason: String) : Exception(reason) {


    object ConnectionException : AppException("Can not connect to Internet")


}