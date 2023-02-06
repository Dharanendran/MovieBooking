package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "payment_table")
class Payment(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0,
    var gateWayName:String,
    var status:String,
    var referenceNo:String,
    var movieCost:Double,
    var charges:Double,
    var totalCost:Double
)
{

}