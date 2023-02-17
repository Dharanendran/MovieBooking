package com.example.ticketbooking

import android.util.Log

object ValidationUtil {

    fun isEmailValid(email:String):Boolean
    {
        val validEmailString = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"
        return validEmailString.toRegex().matches(email.trim())
    }

    fun isPhoneNumberValid(number:String):Boolean
    {
        fun isAnyAlphaContains(number:String):Boolean
        {
            number.forEach {
                if(!it.isDigit())
                    return false
            }
            return true
        }

        return number.length == 10 && isAnyAlphaContains(number) && 6 <= number[0].toInt()
    }
}