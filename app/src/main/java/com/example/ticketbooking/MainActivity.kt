package com.example.ticketbooking


import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.ticketbooking.databinding.ActivityMainBinding
import com.example.ticketbooking.signIn.presentation.SignInPageFragment


class MainActivity : AppCompatActivity(){

    private lateinit var activityMainBinding: ActivityMainBinding
    private val fragmentManager = supportFragmentManager
    var fragmentRemovable:Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        fragmentManager.beginTransaction().add(R.id.activity_main_container, SignInPageFragment()).addToBackStack(SignInPageFragment::class.simpleName).commit()

    }

    fun fragmentTransactionProcess( addToBackStack:Boolean, fragmentTagName:String?, fragment: Fragment)
    {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.activity_main_container, fragment)
        if(addToBackStack)
            transaction.addToBackStack(fragmentTagName)
        transaction.commit()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            android.R.id.home -> fragmentRemovable?.let{ onBackPressed() }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        Toast.makeText(this, "backed",Toast.LENGTH_SHORT).show()
        super.onBackPressed()
    }
}

