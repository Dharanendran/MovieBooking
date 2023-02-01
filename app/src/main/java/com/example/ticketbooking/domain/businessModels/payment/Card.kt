package com.example.ticketbooking.domain.businessModels.payment

import com.example.ticketbooking.domain.businessModels.enums.PaymentStatus

class Card(gateWayName: String,
          status: PaymentStatus,
          referenceNo: String,
          movieCost: Double,
          charges: Double,
          totalCost: Double
): Payment(gateWayName,
    status,
    referenceNo,
    movieCost,
    charges,
    totalCost)
{

}