package com.example.venue.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.venue.data.repository.ListRepository
import com.example.venue.data.model.Result
import com.example.venue.data.model.Venue
import kotlinx.coroutines.launch

class ListViewModel constructor(private val listRepository: ListRepository) : ViewModel() {

    private val _searchVenue: MutableLiveData<Venue> = MutableLiveData()
    val searchVenue: LiveData<Venue> = _searchVenue

    fun searchVenue(near: String) {
        viewModelScope.launch {
            when (val response = listRepository.fetchVenue(near)) {
                is Result.Success<*> -> {
                    _searchVenue.value = response.data as Venue
                }
                is Result.Error -> {

                }
            }

        }
    }
}