package com.example.venue.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Venue(
    @SerializedName("results")
    val results: List<VenueData>
)

data class VenueData(
    @SerializedName("name")
    val name: String?=null,
    @SerializedName("distance")
    val distance: Long,
    @SerializedName("fsq_id")
    val id: String,
    @SerializedName("location")
    val location: Location?= null,
    @SerializedName("photos")
    val photos: List<PhotoData>? = null,
    @SerializedName("description")
    val description: String?= null,
    @SerializedName("email")
    val email: String?=null,
    @SerializedName("tel")
    val tel: String?= null,
    @SerializedName("fax")
    val fax: String?= null,
    @SerializedName("website")
    val website: String?= null,
    @SerializedName("rating")
    val rating: String?= null,
)

data class Location(
    @SerializedName("address")
    val address: String?= null,
    @SerializedName("country")
    val country: String?= null,
    @SerializedName("locality")
    val locality: String?= null
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
