package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*

@Entity(
    tableName = "show_table",
    foreignKeys = [
        ForeignKey(entity = CurrentlyPlayingMovie::class,
                parentColumns = ["id"],
                childColumns = ["currentlyPlayingMovieId"] ), ]
)
class Show (var currentlyPlayingMovieId: Int,
            var time: String,
            var normalSeatsCount: Int,
            var luxurySeatsCount: Int,
            var normalSeatFare: Double,
            var luxurySeatFare: Double )
{
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}