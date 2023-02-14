package com.example.ticketbooking.dataRepository.roomDatabase.daos

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ticketbooking.dataRepository.roomDatabase.entities.Movie
import com.example.ticketbooking.dataRepository.roomDatabase.entities.Theatre
import com.example.ticketbooking.dataRepository.roomDatabase.entities.User

@Dao
interface TheatreDao{

    @Query("SELECT * FROM THEATRE_TABLE")
    fun getAllTheatres():List<Theatre>

    @Query("SELECT * FROM THEATRE_TABLE WHERE id=:theatreId")
    suspend fun getTheatre(theatreId:Int):Theatre

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTheatre(theatre: Theatre):Long

    @Delete
    suspend fun deleteTheatre(theatre: Theatre)

    @Update
    suspend fun updateTheatre(theatre: Theatre)

}