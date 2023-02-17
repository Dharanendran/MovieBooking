package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*

private typealias TheatreAmenity =  com.example.ticketbooking.domain.businessModels.enums.Amenity

@Entity(tableName = "amenity_table")

data class Amenity( var amenityName:String )
{
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}

