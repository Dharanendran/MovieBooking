package com.example.ticketbooking.dataRepository.roomDatabase.daos

import androidx.room.*
import com.example.ticketbooking.dataRepository.roomDatabase.entities.*

@Dao
interface CurrentlyPlayingDao {

    @Query("SELECT * FROM CURRENTLY_PLAYING_MOVIE_TABLE " +
            "WHERE theatreId=:theatreId")
    suspend fun getCurrentlyPlayingMovie(theatreId:Int):List<CurrentlyPlayingMovie>

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrentlyPlayingMovie(currentlyPlayingMovie: CurrentlyPlayingMovie):Long

    @Delete
    suspend fun deleteCurrentlyPlayingMovie(currentlyPlayingMovie: CurrentlyPlayingMovie)

    @Update
    suspend fun updateCurrentlyPlayingMovie(currentlyPlayingMovie: CurrentlyPlayingMovie)

}