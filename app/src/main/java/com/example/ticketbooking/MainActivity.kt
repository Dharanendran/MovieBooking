package com.example.ticketbooking

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewpager.widget.ViewPager
import com.example.ticketbooking.dataRepository.roomDatabase.MovieDataBase
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarMenuView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//interface Response {
//    fun <T> onSuccess(data: T)
//    fun <T> onFailure(error: T)
//}

//var isDarkModeEnabled  = false

class MainActivity : AppCompatActivity() {

    lateinit var viewPager:ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_login)

//        val intent = Intent(this.applicationContext, SignInActivity::class.java)
//        startActivity(intent)

    }

}

//class D(private var context: Context) : Response {
//
//
//    override fun <T> onSuccess(data: T) {
//        println(data)
//        Toast.makeText(context, (data is Int).toString(), Toast.LENGTH_LONG).show()
//        println(data!!::class.java.simpleName)
//    }
//
//
//    override fun<T> onFailure(error: T) {
//        println(this::class.simpleName)
//    }
//
//}