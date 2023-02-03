package com.example.ticketbooking.domain.businessModels.theatre

import android.graphics.Bitmap
import com.example.ticketbooking.domain.businessModels.enums.*
import java.util.*


data class Movie(
    val id:Int,
    val movieName: String,
    val language: String,
    val sensorCertificate: Certificate,
    var synopsis: String,
    val genre: Genre,
    val releaseDate: Date,
    val hero:String?,
    val heroine:String?,
    val villain:String?,
    val director: String,
    val musicDirector: String,
    val poster: Bitmap,
    val screen: Dimension,
    var isFavourite: Boolean
    )
