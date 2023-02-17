package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*

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

class TheatreAmenityLinker(
    var theatreId: Long,
    var amenityId: Long
)
{
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
