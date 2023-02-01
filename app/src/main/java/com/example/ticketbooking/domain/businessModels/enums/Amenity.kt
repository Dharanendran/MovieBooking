package com.example.ticketbooking.domain.businessModels.enums

enum class Amenity{
    FB,
    METRO_TRAIN,
    SOCIAL_SEATING,
    PARKING,
    DOLBY_ATMOS,
    SOFA;

    override fun toString(): String {
        return when(this){
            FB ->"F&B"
            METRO_TRAIN -> "Metro Train"
            SOCIAL_SEATING -> "Social Seating"
            PARKING -> "Parking"
            DOLBY_ATMOS -> "Dolby Atmos"
            SOFA -> "Sofa"
        }
    }
}