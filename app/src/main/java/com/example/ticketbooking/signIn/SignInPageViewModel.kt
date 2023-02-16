package com.example.ticketbooking.signIn

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInPageViewModel() : ViewModel() {

    interface ToastMaker {
        fun makeToast(message: String)
    }

    interface Repository {
        suspend fun checkUserExist(userName: String, password: String, callback: (Boolean) -> Unit)
    }


    var toastMaker: ToastMaker? = null
    var repository: Repository? = null

    val userName: MutableLiveData<String> by lazy{ MutableLiveData("") }
    val passWord: MutableLiveData<String> by lazy { MutableLiveData("") }
    private val mIsLoginSuccessFull by lazy{ MutableLiveData<Boolean>(false) }
    private val mIsProgressBarStarted by lazy{ MutableLiveData(false) }

    fun isLoginSuccessFull(): LiveData<Boolean> = mIsLoginSuccessFull
    fun isProgressBarStarted(): LiveData<Boolean> = mIsProgressBarStarted

    fun signInClick() {


        if ((userName.value as String).isEmpty() || (passWord.value as String).isEmpty()) {
            toastMaker?.makeToast("Enter valid Username or Password")
        } else {
            repository?.let { it ->
                mIsProgressBarStarted.value = true
                viewModelScope.launch(Dispatchers.IO) {
                    it.checkUserExist(
                        userName.value as String,
                        passWord.value as String
                    ) { result ->
                        if (result) {
                            viewModelScope.launch(Dispatchers.Main) { toastMaker?.makeToast("Loginned Successfully") }
                            mIsProgressBarStarted.value = false
                            mIsLoginSuccessFull.value = true
                        } else {
                            viewModelScope.launch(Dispatchers.Main) {
                                toastMaker?.makeToast("UserName ,Password not Present ")
                            }
                            viewModelScope.launch(Dispatchers.Main) {  mIsProgressBarStarted.value = false }
                        }
                    }
                }
            }
        }
    }

    fun setIsLoginSuccessFull(value: Boolean) {
        this.mIsLoginSuccessFull.value = value
    }


}


//class SignInPageViewModelFactory(private val toastMaker: SignInPageViewModel.ToastMaker, private val repository: SignInPageViewModel.Repository):ViewModelProvider.Factory{
//
//    override fun <SignInPageViewModel: ViewModel> create(modelClass: Class<SignInPageViewModel>): SignInPageViewModel {
//        return  SignInPageViewModel(toastMaker,repository)
//    }
//}