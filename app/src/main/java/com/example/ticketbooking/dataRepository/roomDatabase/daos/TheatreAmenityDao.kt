package com.example.ticketbooking.dataRepository.roomDatabase.daos

import androidx.room.*
import com.example.ticketbooking.dataRepository.roomDatabase.entities.Amenity

@Dao
interface TheatreAmenityDao
{
    @Query("SELECT amenityName FROM THEATRE_AMENITY_LINKER_TABLE " +
            "INNER JOIN AMENITY_TABLE ON THEATRE_AMENITY_LINKER_TABLE.amenityId=AMENITY_TABLE.id " +
            "WHERE THEATRE_AMENITY_LINKER_TABLE.theatreId=:theatreId " )
    suspend fun getTheatreAmenities(theatreId: Int):List<String>

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAmenity(amenity: Amenity):Long

    @Delete
    suspend fun deleteAmenity(Amenity: Amenity)

    @Update
    suspend fun updateAmenity(Amenity: Amenity)

}