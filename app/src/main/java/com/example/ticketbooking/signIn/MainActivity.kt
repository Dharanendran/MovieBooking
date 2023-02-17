package com.example.ticketbooking.signIn


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.ticketbooking.R
import com.example.ticketbooking.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){

    private lateinit var activityMainBinding: ActivityMainBinding
    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        fragmentTransactionProcess( false, SignInPageFragment::class.simpleName, SignInPageFragment() )

    }

    fun fragmentTransactionProcess( addToBackStack:Boolean, fragmentTagName:String?, fragment: Fragment) {

        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.activity_main_container, fragment)
        if(addToBackStack)
            transaction.addToBackStack(fragmentTagName)
        transaction.commit()

    }

}

