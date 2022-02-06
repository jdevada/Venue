package com.example.venue.data.di

import com.example.venue.data.network.ApiClient
import com.example.venue.data.network.DataSource
import com.example.venue.data.repository.DetailRepository
import com.example.venue.data.repository.ListRepository

object DependencyInjector {
     val listRepository by lazy {
        ListRepository(DataSource(), ApiClient.getApiService())
    }
    val detailRepository by lazy {
        DetailRepository(DataSource(), ApiClient.getApiService())
    }
}