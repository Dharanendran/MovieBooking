package com.example.ticketbooking.domain.businessModels.theatre

import com.example.ticketbooking.domain.businessModels.enums.Amenity

data class Theatre(
    val id:Int,
    var name: String,
    var doorNo: String,
    var street: String,
    var area: String,
    var city: String,
    val amenities: MutableList<Amenity> = mutableListOf(),
    val currentPlayingMovie: MutableList<CurrentPlayingMovie> = mutableListOf(),
    var isFavourite:Boolean
)

