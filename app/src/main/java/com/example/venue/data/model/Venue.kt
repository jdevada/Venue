package com.example.venue.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Venue(
    @SerializedName("results")
    val results: List<VenueData>
)

data class VenueData(
    @SerializedName("name")
    val name: String,
    @SerializedName("distance")
    val distance: Long,
    @SerializedName("fsq_id")
    val id: String,
    @SerializedName("location")
    val location: Location,
    @SerializedName("photos")
    val photos: List<PhotoData>? = null,
    @SerializedName("description")
    val description: String,
    @SerializedName("email")
    val email: String?=null,
    @SerializedName("tel")
    val tel: String,
    @SerializedName("fax")
    val fax: String,
    @SerializedName("website")
    val website: String,
    @SerializedName("rating")
    val rating: String,
)

data class Location(
    @SerializedName("address")
    val address: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("locality")
    val locality: String
)

data class PhotoData(
    @SerializedName("id")
    val id: String,
    @SerializedName("prefix")
    val prefix: String,
    @SerializedName("suffix")
    val suffix: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("width")
    val width: String
)
