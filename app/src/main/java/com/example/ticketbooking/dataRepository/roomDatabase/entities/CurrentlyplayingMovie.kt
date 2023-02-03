package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*


@Entity(
    tableName = "currently_playing_movie_table",
    foreignKeys = [
        ForeignKey(
            entity = Theatre::class,
            parentColumns = ["id"],
            childColumns = ["theatreId"]
        )
    ]
)
data class CurrentlyPlayingMovie(var theatreId: Int,
                                 var date: String )
{
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}