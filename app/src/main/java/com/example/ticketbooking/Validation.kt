package com.example.ticketbooking

object ValidationUtil {

    fun isEmailValid(email:String):Boolean
    {
        val validEmailString = "^[A-Za-z](.*)([@])(.+)(\\.)(.+)"
        return validEmailString.toRegex().matches(email)
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

        return number.length == 10 && !isAnyAlphaContains(number) && 6 <= number[0].toInt() && 10 > number[0].toInt()
    }
}