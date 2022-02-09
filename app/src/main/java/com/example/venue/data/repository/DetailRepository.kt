package com.example.venue.data.repository

import com.example.venue.data.dao.AppDatabase
import com.example.venue.data.network.ApiService
import com.example.venue.data.network.DataSource
import com.example.venue.data.model.Result

class DetailRepository constructor(
    private val dataSource: DataSource,
    private val apiService: ApiService) {

    suspend fun fetchDetails(id: String): Result {

        return dataSource.executeCall { apiService.fetchDetails(id) }
    }
}