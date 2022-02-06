package com.example.venue.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.venue.data.model.Result
import com.example.venue.data.model.VenueData
import com.example.venue.data.repository.DetailRepository
import kotlinx.coroutines.launch

class DetailViewModel constructor(private val detailRepository: DetailRepository) : ViewModel() {

    private val _venueDetail: MutableLiveData<VenueData> = MutableLiveData()
    val venueDetail: LiveData<VenueData> = _venueDetail


    fun venueDetail(id: String) {
        viewModelScope.launch {
            when (val response = detailRepository.fetchDetails(id)) {
                is Result.Success<*> -> {
                    _venueDetail.value = response.data as VenueData
                }
                is Result.Error -> {

                }
            }
        }
    }
}