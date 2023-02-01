package com.example.ticketbooking.domain.businessModels.enums

enum class Dimension{

    TWO_DIMENSION,
    THREE_DIMENSION;

    override fun toString():String
    {
        return when(this)
        {
            TWO_DIMENSION   -> "2D"
            THREE_DIMENSION -> "3D"
        }
    }
}