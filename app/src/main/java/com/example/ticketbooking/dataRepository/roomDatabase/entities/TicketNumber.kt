package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "ticket_number_table",
    foreignKeys = [
        ForeignKey(
            entity = Order::class,
            parentColumns = ["id"],
            childColumns = ["orderId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TicketNumber(
    var orderId:Long,
    var ticketNo:String )
{

    @PrimaryKey(autoGenerate = true)
    var id:Long = 0

}