package com.example.venue.data.dao

import androidx.room.*
import com.example.venue.data.model.VenueData

@Dao
interface VenueDetailDao {
    @Query("select * from venueEntity where fsq_id = :fsq")
    suspend fun getAll(fsq: String): VenueData

    @Insert
    suspend fun insert(venueData: VenueData)

    @Delete
    suspend fun delete(venueData: VenueData)
}