package com.example.ticketbooking.domain.businessModels.user

import com.example.ticketbooking.domain.businessModels.payment.Payment
import com.example.ticketbooking.domain.businessModels.theatre.Theatre
import com.example.ticketbooking.domain.businessModels.theatre.Movie
import java.util.Date

data class Order(
    var movie: Movie,
    var date: Date,
    var theatre: Theatre,
    var screen: String,
    var ticketNo: String,
    var isFavouriteL: Boolean,
    var payment: Payment
)