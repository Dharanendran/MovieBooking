package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "favourite_theatres_table",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Theatre::class,
            parentColumns = ["id"],
            childColumns = ["theatreId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class FavouriteTheatre(
    var userId:Long,
    var theatreId:Long
)
{
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}