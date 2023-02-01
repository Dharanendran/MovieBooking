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

class ShowTime (val time: String,
                val showId: Int )
{
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0
}