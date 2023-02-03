package com.example.ticketbooking.domain.businessModels.theatre

import com.example.ticketbooking.domain.businessModels.user.User

data class Booking(val id:Int,
                   var user: User,
                   var seatNo: Int,)
