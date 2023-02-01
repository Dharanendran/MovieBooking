package com.example.ticketbooking.domain.businessModels.user

data class User(
    var name: String,
    var phoneNo: String,
    var mailId: String,
    var profilePicture: String?,
    var userName: String,
    var password: String,
    var offers: MutableList<Offer>,
    var orders: MutableList<Order>
)