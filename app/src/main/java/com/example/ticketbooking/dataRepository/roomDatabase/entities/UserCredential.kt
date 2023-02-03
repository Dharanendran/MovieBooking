package com.example.ticketbooking.dataRepository.roomDatabase.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "user_credential_table",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE)]
)
class UserCredential(
    @PrimaryKey(autoGenerate = true)
    var id:Int =0,
    var userId:Int,// USERID MUST BE HERE ONLY,ONCE THE UN & PWD EXIST IT WILL RETURN USERID
    var userName:String,
    var password:String ,
)
