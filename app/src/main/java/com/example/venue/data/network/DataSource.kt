package com.example.venue.data.network

import android.util.Log
import com.example.venue.data.model.Result
import retrofit2.Response

class DataSource {

    companion object {
        private const val TAG = "DataSource"
    }

    suspend fun <T> executeCall(call: suspend () -> Response<T>): Result {
        val response = call.invoke()
        return if (response.isSuccessful) {
            try {
                Result.Success(response.body())
            } catch (e: Exception) {
                Result.Error(e.message ?: "IOException", "")
            }
        } else {
            val error = response.errorBody()
            Log.d(TAG, "executeCall: " + error.toString())
            Result.Error(error.toString(), "")
        }
    }
}

