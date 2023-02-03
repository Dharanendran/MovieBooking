package com.example.ticketbooking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.roomdatabase.R
import com.example.ticketbooking.dataRepository.roomDatabase.MovieDataBase
import com.example.ticketbooking.dataRepository.roomDatabase.entities.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface Response{
    fun <T> onSuccess(data:T)
    fun <T> onFailure(error:T)
}

class MainActivity : AppCompatActivity(),Response{

    init {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            val name:String =""
            MovieDataBase.getInstance(applicationContext,this@MainActivity)
        }

    }

    override fun <T> onSuccess(data: T) {
        var msg=""
        msg = if(data is String) data else data.toString()
        Toast.makeText(this.applicationContext,msg,Toast.LENGTH_SHORT).show()
    }

    override fun <T> onFailure(error: T) {

    }

//    override fun onSuccess(data: String) {
//        Toast.makeText(this.applicationContext,data,Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onFailure(error: Throwable) {
//        Toast.makeText(this.applicationContext,error.message,Toast.LENGTH_SHORT).show()
//    }


}