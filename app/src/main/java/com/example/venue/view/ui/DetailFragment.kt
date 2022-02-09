package com.example.venue.view.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.venue.R
import com.example.venue.data.di.DependencyInjectorImpl
import com.example.venue.data.repository.DetailRepository
import com.example.venue.databinding.FragmentDetailBinding
import com.example.venue.view.viewmodel.DetailViewModel
import com.google.android.material.transition.MaterialContainerTransform

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var detailViewModel: DetailViewModel
    private lateinit var venuePhotoAdapter: VenuePhotoAdapter

    companion object {
        private const val TAG = "DetailFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.nav_host_fragment
            duration = 700
            scrimColor = Color.TRANSPARENT
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString("id") ?: ""
        detailViewModel =
            ViewModelProvider(
                this,
                DetailViewFactory(DependencyInjectorImpl.detailRepository)
            ).get(
                DetailViewModel::class.java
            )

        detailViewModel.venueDetail(id)
        detailViewModel.venueDetail.observe(viewLifecycleOwner) {
            binding.apply {
                venueName.text = it.name?:"No Data Available"
                venueDescription.text = it.description?:"No Data Available"
                venueAddress.text =
                    "${it.location?.address?:""},\n${it.location?.locality?:""}, ${it.location?.country?:""}"
                venueContact.text = "${it.tel?:""}\n${it.email?:"No Data Available"}"
                it.photos?.let {
                    venuePhotoAdapter = VenuePhotoAdapter(it, requireContext())
                    rvPhotoVenues.adapter = venuePhotoAdapter
                }
                venueRating.text = it.rating?:"No Data Available"
            }
        }
    }
}

class DetailViewFactory constructor(
    private val repository: DetailRepository,
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}