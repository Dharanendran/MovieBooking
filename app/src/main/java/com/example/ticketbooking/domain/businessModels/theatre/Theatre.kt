package com.example.ticketbooking.domain.businessModels.theatre

import com.example.ticketbooking.domain.businessModels.enums.Amenity

data class Theatre(
    var name: String,
    var doorNo: String,
    var street: String,
    var area: String,
    var city: String,
    val amenities: MutableList<Amenity>,
    val currentPlayingMovie: MutableList<CurrentPlayingMovie>,
    var isFavourite:Boolean
)

