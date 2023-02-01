package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*
import com.example.ticketbooking.domain.businessModels.payment.Payment

@Entity(
    tableName = "order_table",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"]
        ),
        ForeignKey(
            entity = Movie::class,
            parentColumns = ["id"],
            childColumns = ["movieId"]
        ),
        ForeignKey(
            entity = Theatre::class,
            parentColumns = ["id"],
            childColumns = ["theatreId"]
        ),
        ForeignKey(
            entity = Payment::class,
            parentColumns = ["id"],
            childColumns = ["paymentId"]
        )
    ]
)
class Order(val userId: Int,
            val movieId: Int,
            val theatreId: Int,
            val paymentId: Int,
            var screenName: String,
            var ticketNo: String,
            var isFavourite: Boolean )
{

    @PrimaryKey(autoGenerate = true)
    val id:Int = 0
}