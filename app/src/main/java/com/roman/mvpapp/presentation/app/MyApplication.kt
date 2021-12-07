package com.roman.mvpapp.presentation.app

import android.app.Application
import com.roman.mvpapp.di.AppComponent

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        AppComponent.init(applicationContext)
        AppComponent.get().inject(this)
    }
}
