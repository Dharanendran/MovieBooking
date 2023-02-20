package com.example.ticketbooking.signIn.repository

import android.content.Context
import com.example.ticketbooking.dependencyInjection.DependencyFactory
import com.example.ticketbooking.signIn.domain.IisUserExistRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class IsUserExistRepositoryImpl(private val context: Context): IisUserExistRepository
{
    override fun isUserExist(username: String, password: String, callback: (Boolean) -> Unit)
    {
        CoroutineScope(Dispatchers.IO).launch {
            val isUserExist:Boolean  = DependencyFactory.getInstance(context).getDataBaseObject().getUserCredentialDao().checkUserExist(username, password) == 1
            delay(6000)
            CoroutineScope(Dispatchers.Main).launch {
                callback(isUserExist)
            }
        }
    }

}