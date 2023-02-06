package com.example.ticketbooking.dataRepository.roomDatabase.daos

import androidx.room.*
import com.example.ticketbooking.dataRepository.roomDatabase.entities.Amenity

@Dao
interface AmenityDao {

    @Query("SELECT * FROM AMENITY_TABLE")
    suspend fun getAmenities():List<Amenity>

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAmenity(amenity: Amenity):Long

    @Delete
    suspend fun deleteAmenity(amenity: Amenity)

    @Update
    suspend fun updateAmenity(amenity: Amenity)

}