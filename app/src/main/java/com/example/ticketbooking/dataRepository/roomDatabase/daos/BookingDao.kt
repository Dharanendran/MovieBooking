package com.example.ticketbooking.dataRepository.roomDatabase.daos

import androidx.room.*
import com.example.ticketbooking.dataRepository.roomDatabase.entities.Booking

@Dao
interface  BookingDao {

    data class BookingResult(
        var seatNo: String,
        var name:String,
        var phoneNO:String,
        var mailId:String,
        var profilePicture:String
    )

    @Query("SELECT seatNo,name,phoneNo,mailId,profilePicture FROM BOOKING_TABLE " +
            "INNER JOIN USER_TABLE ON BOOKING_TABLE.userId=USER_TABLE.id " +
            "WHERE BOOKING_TABLE.showTimeId=:showTimeId")
    suspend fun getShowWithBookedUser(showTimeId:Int):List<BookingResult>

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooking(booking: Booking):Long

    @Delete
    suspend fun deleteBooking(booking: Booking)

    @Update
    suspend fun updateBooking(booking: Booking)

}