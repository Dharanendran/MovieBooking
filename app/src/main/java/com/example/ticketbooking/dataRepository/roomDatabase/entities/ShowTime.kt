package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*

@Entity(
    tableName = "show_time_table",
    foreignKeys = [
        ForeignKey(
            entity = Show::class,
            parentColumns = ["id"],
            childColumns = ["showId"])]
)

class ShowTime (var time: String,
                var showId: Int )
{
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}