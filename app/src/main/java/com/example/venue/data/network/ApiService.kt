package com.example.venue.data.network

import com.example.venue.data.model.Venue
import com.example.venue.data.model.VenueData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("places/search")
    suspend fun fetchVenue(
        @Query("near") near: String,
        @Query("sort") sort: String = "distance",
        @Header("Authorization") header: String = "fsq3kipKDuMdd6w1L7L7DRbEh2lX1zyUq1W4s0YA6SRrLBc="
    ): Response<Venue>

    @GET("places/{id}")
    suspend fun fetchDetails(
        @Path("id") id: String,
        @Header("Authorization") header: String = "fsq3kipKDuMdd6w1L7L7DRbEh2lX1zyUq1W4s0YA6SRrLBc=",
        @Query("fields") query:String = "name,description,tel,fax,email,website,social_media,rating,photos,location"
    ): Response<VenueData>
}