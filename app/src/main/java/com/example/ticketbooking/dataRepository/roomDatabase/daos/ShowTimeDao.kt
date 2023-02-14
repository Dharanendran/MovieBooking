package com.example.ticketbooking.dataRepository.roomDatabase.daos

import androidx.room.*
import com.example.ticketbooking.dataRepository.roomDatabase.entities.*

@Dao
interface ShowTimeDao {

    @Query("SELECT * FROM SHOW_TIME_TABLE " +
            "WHERE showId=:showId")
    suspend fun getShowTimes(showId:Int):List<ShowTime>

    @Query("SELECT * FROM SHOW_TIME_TABLE WHERE id=:showTimeId")
    suspend fun getShowTime(showTimeId:Int):ShowTime

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShowTime(showTime: ShowTime):Long

    @Delete
    suspend fun deleteShowTime(showTime: ShowTime)

    @Update
    suspend fun updateShowTime(showTime: ShowTime)
}