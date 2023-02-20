package com.example.ticketbooking.signup.domain

class UserNameExistCheckingUseCase(private val repository: IisUserNameExistRepository) {

    fun isUserNameExist(userName: String, callBack: (isExist: Boolean) -> Unit )
    {
        repository.isUserNameExist(userName, callBack)
    }

}

