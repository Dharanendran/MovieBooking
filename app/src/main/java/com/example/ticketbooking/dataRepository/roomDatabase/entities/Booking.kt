package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*


@Entity(
    tableName = "booking_table",
    foreignKeys = [
        ForeignKey(
            entity = ShowTime::class,
            parentColumns = ["id"],
            childColumns = ["showTimeId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )]
)
class Booking(
    var showTimeId: Long,
    var userId: Long,
    var seatNo: String)
{
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}