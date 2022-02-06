package com.example.venue.view.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.venue.data.model.VenueData
import com.example.venue.databinding.ItemVenueBinding

class VenueListAdapter constructor(private val items: List<VenueData>) :
    RecyclerView.Adapter<VenueListAdapter.ViewHolder>() {

    lateinit var onClick: (id: String, view: View) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVenueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size


    inner class ViewHolder(private val binding: ItemVenueBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: VenueData) {
            binding.apply {
                venueName.text = item.name
                cardView.transitionName = "venueTransition${item.id}"
                cardView.setOnClickListener {
                    onClick.invoke(item.id, it)
                }
            }

        }

    }
}