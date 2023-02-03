package com.example.ticketbooking.domain.businessModels.user

data class User(
    val id:Int,
    var name: String,
    var phoneNo: String,
    var mailId: String,
    var profilePicture: String?,//no need username and password here
    var offers: MutableList<Offer> = mutableListOf(),
    var orders: MutableList<Order> = mutableListOf()
)