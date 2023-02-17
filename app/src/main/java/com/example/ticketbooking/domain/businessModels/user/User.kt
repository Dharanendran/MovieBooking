package com.example.ticketbooking.domain.businessModels.user

data class User(
    val id:Int,
    var name: String,
    var phoneNo: String,
    var mailId: String,
    var profilePicture: String?//no need username and password here, only presents in the central db (api)
)
{
    val offers: MutableList<Offer> by lazy{ mutableListOf() }
    val orders: MutableList<Order> by lazy{ mutableListOf() }
    val favouriteMovies:MutableList<Int> by lazy{ mutableListOf() }
    val favouriteTheatres:MutableList<Int> by lazy { mutableListOf() }
}
