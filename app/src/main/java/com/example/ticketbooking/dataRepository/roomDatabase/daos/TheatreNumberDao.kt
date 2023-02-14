package com.example.ticketbooking.dataRepository.roomDatabase.daos

import androidx.room.*
import com.example.ticketbooking.dataRepository.roomDatabase.entities.TicketNumber

@Dao
interface TicketNumberDao {

    @Insert
    fun insertTicketNumber(ticketNumber: TicketNumber):Long

    @Update
    fun updateTicketNumber(ticketNumber: TicketNumber)

    @Delete
    fun deleteTicketNumber(ticketNumber: TicketNumber)

    @Query("SELECT * FROM ticket_number_table WHERE orderId=:orderId")
    fun getAllTicketNumber(orderId:Long):List<TicketNumber>
}