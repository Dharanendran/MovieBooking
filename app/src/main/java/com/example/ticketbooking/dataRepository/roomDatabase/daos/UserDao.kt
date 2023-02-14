package com.example.ticketbooking.dataRepository.roomDatabase.daos

import android.database.Cursor
import androidx.room.*
import com.example.ticketbooking.dataRepository.roomDatabase.entities.User

@Dao
interface UserDao
{
    @Query("SELECT * FROM USER_TABLE WHERE USER_TABLE.id=:id")
    suspend fun getUser(id:Int):User

    @Query("SELECT * FROM USER_TABLE")
    suspend fun getUsers():List<User>

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user:User):Long

    @Delete
    suspend fun deleteUser(user:User)

    @Update
    suspend fun updateUser(user:User)
}