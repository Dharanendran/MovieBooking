package com.example.ticketbooking.domain.businessModels.theatre

import java.util.*

data class CurrentPlayingMovie(
    var date: Date,
    val shows: MutableList<Show>
)