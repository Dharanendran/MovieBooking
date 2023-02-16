package com.example.ticketbooking.domain.businessModels.enums

enum class Genre
{
    ACTION,
    DRAMA,
    ADVENTURE,
    HORROR,
    COMEDY,
    THRILLER ;

    override fun toString(): String {
        return when(this){
            ACTION -> "Action"
            DRAMA -> "Drama"
            ADVENTURE -> "Adventure"
            HORROR -> "Horror"
            COMEDY -> "Comedy"
            THRILLER -> "Thriller"
        }
    }
}