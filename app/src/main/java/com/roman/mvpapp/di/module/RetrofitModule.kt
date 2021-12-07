package com.roman.mvpapp.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.roman.mvpapp.BuildConfig
import com.roman.mvpapp.data.api.ApiCurrency
import com.roman.mvpapp.di.annotations.DefaultHttpClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().setLenient().create()
    }

    @Provides
    @Singleton
    @DefaultHttpClient
    fun provideHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    @Provides
    @Singleton
    fun provideCurrencyApiService(
        @DefaultHttpClient okHttpClient: OkHttpClient
    ): ApiCurrency {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.CURRENCY_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit.create(ApiCurrency::class.java)
    }
}
