package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*

private typealias TheatreAmenity =  com.example.ticketbooking.domain.businessModels.enums.Amenity

@Entity(tableName = "amenity_table")

data class Amenity(
    @PrimaryKey(autoGenerate = true)
    var id:Long =0,
    var amenityName:String
    )

