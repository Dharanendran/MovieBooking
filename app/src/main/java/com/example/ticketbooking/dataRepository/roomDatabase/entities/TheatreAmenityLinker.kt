package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*
import com.example.ticketbooking.domain.businessModels.enums.Amenity

@Entity(
    tableName = "theatre_amenity_linker_table",
    foreignKeys = [
        ForeignKey(
            entity = Theatre::class,
            parentColumns = ["id"],
            childColumns = ["theatreId"],
            onDelete = ForeignKey.CASCADE
            ),
        ForeignKey(
            entity = Amenity::class,
            parentColumns = ["id"],
            childColumns = ["amenityId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
    )

class TheatreAmenityLinker(val theatreId:Int,
                           val amenityId:Int )