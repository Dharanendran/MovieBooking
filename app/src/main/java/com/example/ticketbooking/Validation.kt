package com.example.ticketbooking

import android.util.Log
import com.google.android.gms.auth.api.identity.SignInPassword

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

    fun isPasswordStrong(password: String):Boolean
    {
        var isContainsUpper = false
        var isContainsDigit = false
        var isContainsSpecial = false

        password.forEach {
            if(it.isDigit())
                isContainsDigit = true
            if(it.isUpperCase())
                isContainsUpper = true
            if(!(it.isLetter() || it.isDigit()))
                isContainsSpecial = true
        }

        if(password.length>=8 && isContainsUpper && isContainsDigit && isContainsSpecial)
            return true
        return false

//        ^                         Start anchor
//            (?=.*[A-Z].*[A-Z])        Ensure string has two uppercase letters.
//        (?=.*[!@#$&*])            Ensure string has one special case letter.
//        (?=.*[0-9].*[0-9])        Ensure string has two digits.
//        (?=.*[a-z].*[a-z].*[a-z]) Ensure string has three lowercase letters.
//        .{8}                      Ensure string is of length 8.
//        $                         End anchor.

    }

}