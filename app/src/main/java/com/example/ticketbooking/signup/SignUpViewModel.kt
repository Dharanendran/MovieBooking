package com.example.ticketbooking.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ticketbooking.ValidationUtil
import com.example.ticketbooking.dataRepository.roomDatabase.entities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpPageViewModel : ViewModel() {

    interface Repository {
        suspend fun createAccount(user: User, callback:(id:Long)->Unit)
    }

    interface ToastMaker {
        fun makeToast(message: String)
    }

    val name: MutableLiveData<String> by lazy { MutableLiveData("") }
    val mobileNo: MutableLiveData<String> by lazy { MutableLiveData("") }
    val emailId: MutableLiveData<String> by lazy { MutableLiveData("") }

    var repository: Repository? = null
    var toastMaker: ToastMaker? = null

    fun onClickCreateAccount() {

        if (ValidationUtil.isEmailValid(emailId.value as String)) {

            if (ValidationUtil.isPhoneNumberValid(mobileNo.value as String)) {

                viewModelScope.launch(Dispatchers.IO) {
                    repository?.createAccount(
                        User(
                            10,
                            name.value as String,
                            mobileNo.value as String,
                            emailId.value as String,
                            ""
                        )
                    ){
                        viewModelScope.launch(Dispatchers.Main) {
                            toastMaker?.makeToast(" SuccessFully Created, Your Id( $it ) ")
                        }
                    }
                }
            }
            else
                toastMaker?.makeToast(" Enter Valid Mobile No !")
        }

        else
            toastMaker?.makeToast(" Enter valid Email Id !")

    }
}