package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*

@Entity(
    tableName = "order_table",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"]
        )]
)
class Order(var userId: Int,
            var movieId: Int,
            var theatreId: Int,
            var paymentId: Int,
            var screenName: String,
            var ticketNo: String )
{
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}