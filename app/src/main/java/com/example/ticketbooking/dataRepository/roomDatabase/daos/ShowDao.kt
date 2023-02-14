package com.example.ticketbooking.dataRepository.roomDatabase.daos

import androidx.room.*
import com.example.ticketbooking.dataRepository.roomDatabase.entities.*
@Dao
interface ShowDao {

    @Query("SELECT * FROM SHOW_TABLE " +
            "WHERE currentlyPlayingMovieId=:currentlyPlayingMovieId")
    suspend fun getCurrentlyPlayingMovie(currentlyPlayingMovieId: Int):Show

    @Query("SELECT * FROM SHOW_TABLE WHERE id=:showId")
    suspend fun getShow(showId:Int):Show

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrentlyPlayingMovie(show: Show):Long

    @Delete
    suspend fun deleteCurrentlyPlayingMovie(show:Show)

    @Update
    suspend fun updateCurrentlyPlayingMovie(show:Show)
}