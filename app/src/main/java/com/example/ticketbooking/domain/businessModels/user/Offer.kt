package com.example.ticketbooking.domain.businessModels.user

import java.util.Date

data class Offer(
    val id:String,
    val brandName: String,
    val offerName: String,
    val promoCode: String,
    var validUpto: Date
)