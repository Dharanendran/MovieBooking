package com.example.ticketbooking.signup.domain

import com.example.ticketbooking.dataRepository.roomDatabase.entities.User
import com.google.android.gms.auth.api.identity.SignInPassword

interface IcreateUserAccountRepository
{
    fun createUserAccount(user: User,username:String, password:String,  callback: (id: Long) -> Unit)
}

