package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*

@Entity(
    tableName = "show_table",
    foreignKeys = [
        ForeignKey(entity = CurrentlyPlayingMovie::class,
                parentColumns = ["id"],
                childColumns = ["currentlyPlayingMovieId"] ), ]
)
class Show (val currentlyPlayingMovie: Int,
            val time: String)
{
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}