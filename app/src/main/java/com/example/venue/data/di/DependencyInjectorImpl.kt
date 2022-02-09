package com.example.venue.data.di

import android.content.Context
import com.example.venue.App
import com.example.venue.data.dao.AppDatabase
import com.example.venue.data.network.ApiClient
import com.example.venue.data.network.DataSource
import com.example.venue.data.repository.DetailRepository
import com.example.venue.data.repository.ListRepository

class DependencyInjectorImpl {

    companion object {
        val listRepository by lazy {
            ListRepository(DataSource(), ApiClient.getApiService())
        }
        val detailRepository by lazy {
            DetailRepository(DataSource(), ApiClient.getApiService())
        }
        fun getAppDataBase(context: Context) = AppDatabase.getInstance(context)
    }
}