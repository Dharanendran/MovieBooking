package com.example.ticketbooking.signup.repository

import android.content.Context
import com.example.ticketbooking.dependencyInjection.DependencyFactory
import com.example.ticketbooking.signup.domain.IisUserNameExistRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IsUserNameExistRepositoryImpl(private val context: Context): IisUserNameExistRepository {

    override fun isUserNameExist(userName: String, callback: (isExist: Boolean) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val isExist =
                DependencyFactory.getInstance(context).getDataBaseObject().getUserCredentialDao()
                    .isUserNameExist(userName) == 1
            CoroutineScope(Dispatchers.Main).launch { callback(isExist) }
        }
    }

}