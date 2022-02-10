package com.example.venue.data.repository

import com.example.venue.data.model.Result
import com.example.venue.data.network.ApiService
import com.example.venue.data.network.DataSource

class DetailRepository(
    private val dataSource: DataSource,
    private val apiService: ApiService) {

    suspend fun fetchDetails(id: String): Result {
        return dataSource.executeCall { apiService.fetchDetails(id) }
    }
}