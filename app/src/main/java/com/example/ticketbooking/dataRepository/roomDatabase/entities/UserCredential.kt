package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_credential_table")
class UserCredential(
    val userName:String,
    val password:String,
)
{
    @PrimaryKey(autoGenerate = true)
    var id:Int =0
}