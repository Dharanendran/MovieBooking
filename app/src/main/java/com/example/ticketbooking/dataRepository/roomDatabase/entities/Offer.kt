package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*


@Entity(
    tableName = "offer_table",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE
    )]

)
class Offer (
    val userId: Int,
    val brandName: String,
    val offerName: String,
    val promoCode: String,
    val validUpto: String
)
{
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}