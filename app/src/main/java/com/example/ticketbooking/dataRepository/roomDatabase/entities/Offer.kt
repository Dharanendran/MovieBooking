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
    var userId: Int,
    var brandName: String,
    var offerName: String,
    var promoCode: String,
    var validUpto: String
)
{
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}