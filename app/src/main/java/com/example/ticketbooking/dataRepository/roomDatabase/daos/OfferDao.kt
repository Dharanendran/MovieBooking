package com.example.ticketbooking.dataRepository.roomDatabase.daos

import androidx.room.*
import com.example.ticketbooking.dataRepository.roomDatabase.entities.Offer
import com.example.ticketbooking.dataRepository.roomDatabase.entities.User

@Dao
interface  OfferDao {

    @Query("SELECT * FROM OFFER_TABLE " +
            "WHERE userId=:userId")
    suspend fun getOffers(userId:Int):List<Offer>

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOffer(offer: Offer):Long

    @Delete
    suspend fun deleteOffer(offer: Offer)

    @Update
    suspend fun updateOffer(offer: Offer)
}