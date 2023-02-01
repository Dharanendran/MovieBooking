package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*

@Entity(tableName = "amenity_table")
class Amenity(val amenityName: String)
{
    @PrimaryKey(autoGenerate = true)
    var id:Int =0
}
