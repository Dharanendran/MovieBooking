package com.example.ticketbooking.dependencyInjection

import android.content.Context
import com.example.ticketbooking.dataRepository.roomDatabase.MovieDataBase
import com.example.ticketbooking.signIn.SignInPageRepository

class DependencyFactory private constructor(){

    private lateinit var context: Context
    var databaseInstance:MovieDataBase? = null



    companion object {

        var instance:DependencyFactory? = null
        fun getInstance(applicationContext: Context): DependencyFactory
        {
            instance ?: run { instance = DependencyFactory().apply { this.context = applicationContext } }
            return instance as DependencyFactory
        }

    }

    suspend fun getDataBaseObject():MovieDataBase{
        databaseInstance?:run{
                databaseInstance = MovieDataBase.getInstance(context)
        }
        return databaseInstance as MovieDataBase
    }

    fun getSignInPageRepository() = SignInPageRepository(context)


}