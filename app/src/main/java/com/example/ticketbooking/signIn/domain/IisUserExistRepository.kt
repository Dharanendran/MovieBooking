package com.example.ticketbooking.signIn.domain

interface IisUserExistRepository
{
    fun isUserExist(username:String, password:String, callback: (Boolean)->Unit)
}