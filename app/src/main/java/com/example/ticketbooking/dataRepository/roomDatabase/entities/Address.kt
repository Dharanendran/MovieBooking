package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*


@Entity( tableName = "address_table" )

class Address (var doorNo: String,
               var street: String,
               var area: String,
               var city:String )
{
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}