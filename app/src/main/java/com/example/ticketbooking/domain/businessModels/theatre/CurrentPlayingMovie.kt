package com.example.ticketbooking.domain.businessModels.theatre

import java.util.*

data class CurrentPlayingMovie(
    val id:Int,
    var date: Date,
    val shows: MutableList<Show> = mutableListOf()
)