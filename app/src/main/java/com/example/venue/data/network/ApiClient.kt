package com.example.venue.data.network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val baseUrl = "https://api.foursquare.com/v3/"

    fun getApiService(): ApiService {
        val okHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        val retrofit =
            Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient.build()).addConverterFactory(
                GsonConverterFactory.create(Gson())
            )
        return retrofit.build().create(ApiService::class.java)
    }
}