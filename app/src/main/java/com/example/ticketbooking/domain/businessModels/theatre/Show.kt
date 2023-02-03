package com.example.ticketbooking.domain.businessModels.theatre

data class Show(
    val id:Int,
    var movie: Movie,
    var showTimings: MutableList<ShowTime> = mutableListOf()
)
