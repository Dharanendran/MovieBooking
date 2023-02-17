package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*

@Entity(
    tableName = "show_table",
    foreignKeys = [
        ForeignKey(
            entity = CurrentlyPlayingMovie::class,
            parentColumns = ["id"],
            childColumns = ["currentlyPlayingMovieId"],
            onDelete = ForeignKey.CASCADE
        ),
    ]
)
class Show(
    var currentlyPlayingMovieId: Long,
    var time: String,
    var normalSeatsCount: Int,
    var luxurySeatsCount: Int,
    var normalSeatFare: Double,
    var luxurySeatFare: Double
)
{
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
