package com.example.ticketbooking.domain.businessModels.theatre

import java.sql.Time

data class ShowTime(
    var time: Time,
    var normalSeatCount: Int,
    var luxurySeatCount: Int,
    var normalSeatFare: Int,
    var luxurySeatFare: Int,
    var bookings: MutableList<Booking>
)
