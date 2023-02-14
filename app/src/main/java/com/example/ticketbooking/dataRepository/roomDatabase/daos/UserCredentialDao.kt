package com.example.ticketbooking.dataRepository.roomDatabase.daos

import androidx.room.*
import com.example.ticketbooking.dataRepository.roomDatabase.entities.User
import com.example.ticketbooking.dataRepository.roomDatabase.entities.UserCredential

@Dao
interface  UserCredentialDao {


//    @Query("IF EXISTS (SELECT * FROM USER_CREDENTIAL_TABLE WHERE userName=:userName AND password=:password) " +
//            "BEGIN " +
//            "SELECT userId" +
//            "FROM USER_CREDENTIAL_TABLE " +
//            "WHERE userName=:userName AND password=:password; " +
//            "END ELSE " +
//            "BEGIN " +
//            "SELECT -1; " +
//            "END;")

    @Query("SELECT userId FROM USER_CREDENTIAL_TABLE " +
            "WHERE userName=:userName AND password=:password")
    suspend fun getUserAccount(userName:String, password:String):Int

    @Query("SELECT COUNT(*) FROM USER_CREDENTIAL_TABLE " +
            "WHERE userName=:userName AND password=:password")
    suspend fun checkUserExist(userName:String, password:String):Int

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserAccount(userCredential: UserCredential):Long

    @Delete
    suspend fun deleteUserAccount(userCredential: UserCredential)

    @Update
    suspend fun updateUserAccount(userCredential: UserCredential)
}