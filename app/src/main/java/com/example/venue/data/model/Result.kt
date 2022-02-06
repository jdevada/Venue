package com.example.venue.data.model

sealed class Result{
    data class Success<T>(val data: T) : Result()
    data class Error(val errorMsg: String, val errorCode: String) : Result()
}

