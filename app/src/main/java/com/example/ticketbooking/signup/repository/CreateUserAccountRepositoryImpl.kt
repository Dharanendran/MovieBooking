package com.example.ticketbooking.signup.repository

import android.content.Context
import android.util.Log
import com.example.ticketbooking.dataRepository.roomDatabase.entities.User
import com.example.ticketbooking.dataRepository.roomDatabase.entities.UserCredential
import com.example.ticketbooking.dependencyInjection.DependencyFactory
import com.example.ticketbooking.signup.domain.IcreateUserAccountRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateUserAccountRepositoryImpl(private val context: Context): IcreateUserAccountRepository
{
    override fun createUserAccount(user: User, username:String, password:String, callback: (id: Long) -> Unit)
    {
        CoroutineScope(Dispatchers.IO).launch {
            val id = DependencyFactory.getInstance(context).getDataBaseObject().getUserDao().insertUser(user)
            DependencyFactory.getInstance(context).getDataBaseObject().getUserCredentialDao().insertUserAccount(
                UserCredential(id, username, password )
            )
            Log.v("dharan", "$id")
            CoroutineScope(Dispatchers.Main).launch { callback(id) }
        }
    }

}
