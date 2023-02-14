package com.example.ticketbooking.dataRepository.roomDatabase.daos

import androidx.room.*
import com.example.ticketbooking.dataRepository.roomDatabase.entities.FavouriteTheatre

@Dao
interface FavouriteTheatreDao {

    @Query("SELECT * FROM favourite_theatres_table WHERE userId=:userId" )
    fun getFavouriteTheatre(userId:Int):List<FavouriteTheatre>

    @Insert
    fun insertFavouriteTheatre(theatre:FavouriteTheatre):Long

    @Update
    fun updateFavouriteTheatre(theatre:FavouriteTheatre)

    @Delete
    fun deleteFavouriteTheatre(theatre:FavouriteTheatre)
}