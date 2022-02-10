package com.example.venue.data.repository

import com.example.venue.data.network.ApiService
import com.example.venue.data.network.DataSource
import com.example.venue.data.model.Result

class ListRepository(
    private val dataSource: DataSource,
    private val apiService: ApiService
) {
    suspend fun fetchVenue(near: String): Result {
        return dataSource.executeCall { apiService.fetchVenue(near) }
    }
}