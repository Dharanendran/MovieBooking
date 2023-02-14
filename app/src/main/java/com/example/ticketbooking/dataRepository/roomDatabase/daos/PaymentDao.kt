package com.example.ticketbooking.dataRepository.roomDatabase.daos

import androidx.room.*
import com.example.ticketbooking.dataRepository.roomDatabase.entities.Payment

@Dao
interface PaymentDao {

    @Query("SELECT * FROM PAYMENT_TABLE WHERE id=:paymentId")
    suspend fun getPayment(paymentId:Int):Payment


    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPayment(payment: Payment):Long

    @Delete
    suspend fun deletePayment(payment: Payment)

    @Update
    suspend fun updatePayment(payment: Payment)

}