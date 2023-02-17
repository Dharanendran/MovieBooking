package com.example.ticketbooking.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ticketbooking.ValidationUtil
import com.example.ticketbooking.dataRepository.roomDatabase.entities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.UUID

class SignUpPageViewModel : ViewModel() {

    interface Repository {
        suspend fun createAccount(user: User, callback: (id: Long) -> Unit)
        suspend fun isUserNameExist(userName: String, callback: (isExist: Boolean) -> Unit)
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

        if (ValidationUtil.isEmailValid((emailId.value).toString())) {

            if (ValidationUtil.isPhoneNumberValid((mobileNo.value).toString())) {

                viewModelScope.launch(Dispatchers.IO) {

                    repository?.isUserNameExist(emailId.value.toString()) {
                        if (!it)
                            viewModelScope.launch(Dispatchers.IO) {

                                repository?.createAccount(
                                    User(
                                        name.value.toString(),
                                        mobileNo.value.toString(),
                                        emailId.value.toString(),
                                        ""
                                    )
                                ) {
                                    viewModelScope.launch(Dispatchers.Main) {
                                        toastMaker?.makeToast(
                                            " Successfully Created"
                                        )
                                    }
                                }
                            }
                        else
                           viewModelScope.launch(Dispatchers.Main) { toastMaker?.makeToast("Username Already Exist !") }
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