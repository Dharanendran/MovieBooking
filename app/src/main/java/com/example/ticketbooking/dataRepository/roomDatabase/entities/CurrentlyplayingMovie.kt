package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*


@Entity(
    tableName = "currently_playing_movie_table",
    foreignKeys = [
        ForeignKey(
            entity = Theatre::class,
            parentColumns = ["id"],
            childColumns = ["theatreId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CurrentlyPlayingMovie(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var theatreId: Long,
    var date: String
)