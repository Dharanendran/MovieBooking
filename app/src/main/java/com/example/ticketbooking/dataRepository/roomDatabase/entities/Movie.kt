package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*


@Entity(
    tableName = "movie_table",
)
class Movie(val movieName: String,
            val language: String,
            var sensorCertificate: String,
            var synopsis: String,
            var genre: String,
            var releaseDate: String,
            val hero:String?,
            val heroine:String?,
            val villain:String? )
{
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0
}