package com.example.ticketbooking.dataRepository.roomDatabase.daos

import android.database.Cursor
import androidx.room.*
import com.example.ticketbooking.dataRepository.roomDatabase.entities.*

@Dao
interface OrderDao {

    data class OrderResultType(
        var screenName: String,
        var ticketNo: String,
        var movieName: String,
        var language: String,
        var sensorCertificate: String,
        var synopsis: String,
        var genre: String,
        var releaseDate: String,
        var hero: String?,
        var heroine: String?,
        var villain: String?,
        var isFavouriteMovie: Boolean,
        var theatreName: String,
        var doorNo: String,
        var street: String,
        var area: String,
        var city: String,
        var isFavouriteTheatre: Boolean,
        var gateWayName: String,
        var status: String,
        var referenceNo: String,
        var movieCost: Double,
        var charges: Double,
        var totalCost: Double
    )


    @Query(
        "SELECT screenName,ticketNo,movieName,language,sensorCertificate,synopsis,genre,releaseDate,hero," +
                "heroine,villain,isFavouriteMovie,theatreName,doorNo,street,area,city,isFavouriteTheatre,gateWayName,status,referenceNo,movieCost,charges,totalCost" +
                " FROM ORDER_TABLE " +
                "INNER JOIN MOVIE_TABLE ON MOVIE_TABLE.id=ORDER_TABLE.movieId " +
                "INNER JOIN THEATRE_TABLE ON THEATRE_TABLE.id=ORDER_TABLE.theatreId " +
                "INNER JOIN PAYMENT_TABLE ON PAYMENT_TABLE.id=ORDER_TABLE.paymentId " +
                "WHERE ORDER_TABLE.userId=:userId"
    )
    suspend fun getUserSpecificOrder(userId: Int):List<OrderResultType>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(order: Order):Long

    @Delete
    suspend fun deleteOrder(order: Order)

    @Update
    suspend fun updateUser(order: Order)
}