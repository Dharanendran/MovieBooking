package com.example.ticketbooking.signIn.domain

class IsUserExistUseCase(private val repository: IisUserExistRepository)
{
    fun isUserExist(username: String, password: String, callback: (Boolean) -> Unit)
    {
        repository.isUserExist(username, password, callback)
    }

}



