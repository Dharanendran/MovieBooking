package com.example.ticketbooking.domain.businessModels.payment

import com.example.ticketbooking.domain.businessModels.enums.PaymentStatus

open class Payment(
    var gateWayName: String,
    var status: PaymentStatus,
    val referenceNo: String,
    val movieCost: Double,
    val charges: Double,
    val totalCost: Double
)
{
    val id:Int = 0

}