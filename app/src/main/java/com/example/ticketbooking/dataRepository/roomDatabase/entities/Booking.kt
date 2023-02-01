package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*


@Entity(
    tableName = "seat_table",
    foreignKeys = [
        ForeignKey(
            entity = ShowTime::class,
            parentColumns = ["id"],
            childColumns = ["showTimeId"],
            onDelete = ForeignKey.CASCADE),
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )]
)
class Booking (var showTimeId: Int,
               var userId: Int,
               var seatNo: String )
{
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}