package com.example.ticketbooking.domain.businessModels.enums

enum class Certificate
{
    A,
    UA,
    U;

    override fun toString(): String {
        if(this == UA)
            return "U/A"
        return super.toString()
    }
}