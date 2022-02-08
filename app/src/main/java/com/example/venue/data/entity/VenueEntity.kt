package com.example.venue.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.venue.data.model.Location
import com.example.venue.data.model.PhotoData


@Entity(tableName = "venueEntity")
data class VenueEntity(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "distance")
    val distance: Long,
    @ColumnInfo(name = "fsq_id")
    val id: String,
    @ColumnInfo(name = "location")
    val location: Location,
    @ColumnInfo(name = "photos")
    val photos: List<PhotoData>? = null,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "email")
    val email: String? = null,
    @ColumnInfo(name = "tel")
    val tel: String,
    @ColumnInfo(name = "fax")
    val fax: String,
    @ColumnInfo(name = "website")
    val website: String,
    @ColumnInfo(name = "rating")
    val rating: String,
)