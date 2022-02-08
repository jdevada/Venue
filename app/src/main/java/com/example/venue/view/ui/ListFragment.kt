package com.example.venue.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.venue.R
import com.example.venue.data.di.DependencyInjectorImpl
import com.example.venue.data.repository.ListRepository
import com.example.venue.databinding.FragmentListBinding
import com.example.venue.view.viewmodel.ListViewModel

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var venueListAdapter: VenueListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listViewModel =
            ViewModelProvider(this, ListViewFactory(DependencyInjectorImpl.listRepository)).get(
                ListViewModel::class.java
            )
        listViewModel.searchVenue.observe(viewLifecycleOwner) {
            binding.apply {
                venueListAdapter = VenueListAdapter(it.results.filter { it.distance <= 1000 })
                rvListVenues.adapter = venueListAdapter
                venueListAdapter.onClick = { id, view ->
                    val bundle = Bundle().apply {
                        putString("id", id)
                    }
                    val extras = FragmentNavigatorExtras(view to "venueTransition")
                    findNavController().navigate(
                        R.id.action_listFragment_to_detailFragment,
                        bundle, null,
                        extras
                    )
                }
            }

        }
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    listViewModel.searchVenue(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    if (it.length > 3)
                        listViewModel.searchVenue(newText)
                }
                return false
            }

        })
    }
}

class ListViewFactory constructor(
    private val repository: ListRepository,
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}