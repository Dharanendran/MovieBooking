package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*

@Entity(
    tableName = "order_table",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)

class Order(
    var userId: Long,
    var movieId: Long,
    var theatreId: Long,
    var paymentId: Long,
    var screenName: String
)
{
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
