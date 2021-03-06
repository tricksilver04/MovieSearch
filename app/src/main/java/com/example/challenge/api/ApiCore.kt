package com.example.challenge.api

import com.facebook.stetho.okhttp3.StethoInterceptor

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiCore {

    private const val CONNECT_TIMEOUT = 30
    private const val WRITE_TIMEOUT = 480
    private const val READ_TIMEOUT = 30

    var client : OkHttpClient? = null

    fun getRetrofit(baseUrl: String): Retrofit {
        client = OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}