package com.example.ticketbooking.signIn.presentation

import android.util.Log
import androidx.lifecycle.*
import com.example.ticketbooking.signIn.domain.IsUserExistUseCase
import com.example.ticketbooking.signup.domain.CreateUserAccountUseCase

class SignInPageViewModel() : ViewModel() {

    interface ToastMaker {
        fun makeToast(message: String)
    }


    var toastMaker: ToastMaker? = null
    var isUserExistUseCase: IsUserExistUseCase? = null
    var createUserAccountUseCase:CreateUserAccountUseCase? = null

    val userName: MutableLiveData<String> by lazy { MutableLiveData("") }
    val passWord: MutableLiveData<String> by lazy { MutableLiveData("") }
    private val mIsLoginSuccessFull by lazy { MutableLiveData<Boolean>(false) }
    private val mIsProgressBarStarted by lazy { MutableLiveData(false) }
    private val mIsGoogleSignInClicked by lazy { MutableLiveData(false) }
    private val mIsSignUpClicked by lazy { MutableLiveData(false) }

    fun isLoginSuccessFull(): LiveData<Boolean> = mIsLoginSuccessFull
    fun isProgressBarStarted(): LiveData<Boolean> = mIsProgressBarStarted
    fun isGoogleSignInClicked(): LiveData<Boolean> = mIsGoogleSignInClicked
    fun isSignUpClicked(): LiveData<Boolean> = mIsSignUpClicked

    fun signInOnClick() {

        if ((userName.value as String).isEmpty() || (passWord.value as String).isEmpty())

            toastMaker?.makeToast("Username or Password can't be Empty !")

        else {
            isUserExistUseCase?.let { it ->
                mIsProgressBarStarted.value = true
                it.isUserExist( userName.value as String, passWord.value as String) { result ->

                    if (result)
                    {
                        toastMaker?.makeToast("Loginned Successfully")
                        mIsProgressBarStarted.value = false
                        mIsLoginSuccessFull.value = true
                    }
                    else
                    {
                        toastMaker?.makeToast("UserName ,Password not Present ")
                        mIsProgressBarStarted.value = false
                    }

                }
            }
        }
    }

    fun signUpOnClick() {
        mIsSignUpClicked.value = true
    }

    fun googleSignInOnClick() {
        mIsGoogleSignInClicked.value = true
    }

    fun setIsLoginSuccessFull(value: Boolean) {
        this.mIsLoginSuccessFull.value = value
    }

}

