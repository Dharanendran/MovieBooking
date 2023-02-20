package com.example.ticketbooking.dependencyInjection

import android.content.Context
import com.example.ticketbooking.dataRepository.roomDatabase.MovieDataBase
import com.example.ticketbooking.signIn.domain.IisUserExistRepository
import com.example.ticketbooking.signIn.domain.IsUserExistUseCase
import com.example.ticketbooking.signIn.repository.IsUserExistRepositoryImpl
import com.example.ticketbooking.signup.domain.CreateUserAccountUseCase
import com.example.ticketbooking.signup.domain.IcreateUserAccountRepository
import com.example.ticketbooking.signup.domain.IisUserNameExistRepository
import com.example.ticketbooking.signup.domain.UserNameExistCheckingUseCase
import com.example.ticketbooking.signup.repository.CreateUserAccountRepositoryImpl
import com.example.ticketbooking.signup.repository.IsUserNameExistRepositoryImpl

class DependencyFactory private constructor() {

    private lateinit var context: Context
    private var databaseInstance: MovieDataBase? = null


    companion object {

        var instance: DependencyFactory? = null
        fun getInstance(applicationContext: Context): DependencyFactory {
            instance ?: run {
                instance = DependencyFactory().apply { this.context = applicationContext }
            }
            return instance as DependencyFactory
        }

    }

    suspend fun getDataBaseObject(): MovieDataBase {
        databaseInstance ?: run {
            databaseInstance = MovieDataBase.getInstance(context)
        }
        return databaseInstance as MovieDataBase
    }

    fun getUserNameExistCheckingUseCase(repository: IisUserNameExistRepository) = UserNameExistCheckingUseCase(repository)
    fun getCreateUserAccountUseCase(repository: IcreateUserAccountRepository) = CreateUserAccountUseCase(repository)

    fun getCreateUserAccountRepositoryImpl() = CreateUserAccountRepositoryImpl(context)
    fun getIsUserNameExistRepositoryImpl() = IsUserNameExistRepositoryImpl(context)



    fun getIsUserExistUseCase( repository: IisUserExistRepository ) = IsUserExistUseCase(repository)

    fun getIsUserExistRepositoryImpl() = IsUserExistRepositoryImpl( context )

}