package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*
@Entity( tableName = "theatre_table",
)
class Theatre(var theatreName: String,
              var doorNo: String,
              var street: String,
              var area: String,
              var city: String,
              var isFavouriteTheatre: Boolean )
{
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}