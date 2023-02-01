package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.*

@Entity(
    tableName = "user_table",
    indices = [Index(value=["credentialId","id"], unique = true)],
    foreignKeys = [
        ForeignKey(
        entity = UserCredential::class,
        parentColumns = ["id"],
        childColumns = ["credentialId"],
        onDelete = ForeignKey.CASCADE)]
)
class User(val name:String,
           val phoneNO:String,
           val mailId:String,
           val profilePicture:String,
           val credentialId:Int,
)
{
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0
}