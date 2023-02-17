package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*

@Entity(
    tableName = "show_time_table",
    foreignKeys = [
        ForeignKey(
            entity = Show::class,
            parentColumns = ["id"],
            childColumns = ["showId"],
            onDelete = ForeignKey.CASCADE
        )]
)

class ShowTime(
    var time: String,
    var showId: Long
)
{
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}