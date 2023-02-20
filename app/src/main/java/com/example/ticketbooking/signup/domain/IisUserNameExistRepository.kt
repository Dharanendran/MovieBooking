package com.example.ticketbooking.signup.domain

interface IisUserNameExistRepository
{
    fun isUserNameExist(userName: String, callback: (isExist: Boolean) -> Unit)
}