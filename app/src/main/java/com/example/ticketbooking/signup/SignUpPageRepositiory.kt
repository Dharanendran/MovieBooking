package com.example.ticketbooking.signup

import android.content.Context
import com.example.ticketbooking.dataRepository.roomDatabase.entities.User
import com.example.ticketbooking.dependencyInjection.DependencyFactory

class SignUpPageRepository( private val context:Context ):SignUpPageViewModel.Repository {

    override suspend fun createAccount(user: User, callback: (id: Long) -> Unit) {
        val id:Long = DependencyFactory.getInstance(context).getDataBaseObject().getUserDao().insertUser(user)
        callback(id)
    }

}