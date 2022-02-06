package com.example.venue.view.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.venue.data.model.PhotoData
import com.example.venue.databinding.ItemPhotoVenueBinding

class VenuePhotoAdapter constructor(
    private val items: List<PhotoData>,
    private val context: Context
) :
    RecyclerView.Adapter<VenuePhotoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemPhotoVenueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size


    inner class ViewHolder(private val binding: ItemPhotoVenueBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PhotoData) {
            binding.apply {
                Glide.with(context).load(item.prefix + item.width + "x" + item.height + item.suffix)
                    .into(venuePhoto)
            }

        }

    }
}