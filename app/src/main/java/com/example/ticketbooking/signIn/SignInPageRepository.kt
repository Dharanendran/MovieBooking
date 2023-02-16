package com.example.ticketbooking.signIn

import android.content.Context
import com.example.ticketbooking.signIn.SignInPageViewModel
import com.example.ticketbooking.dependencyInjection.DependencyFactory
import kotlinx.coroutines.delay


class SignInPageRepository(private val context: Context) : SignInPageViewModel.Repository {

    override suspend fun checkUserExist(
        userName: String,
        password: String,
        callback: (Boolean) -> Unit
    ){

        val db = DependencyFactory.getInstance(context).getDataBaseObject()
        val result: Int = db.getUserCredentialDao().checkUserExist(userName, password)
        delay(6000)
        if (result == 1)
            callback(true)
        else
            callback(false)


    }
}