package com.example.ticketbooking.domain.businessModels.theatre

data class Show(
    var movie: Movie,
    var showTimings: MutableList<ShowTime>
)
