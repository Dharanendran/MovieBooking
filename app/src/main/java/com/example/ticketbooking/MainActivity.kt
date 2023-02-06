package com.example.ticketbooking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.roomdatabase.R
import com.example.ticketbooking.dataRepository.roomDatabase.MovieDataBase
import com.example.ticketbooking.dataRepository.roomDatabase.entities.User
import com.example.ticketbooking.dataRepository.roomDatabase.entities.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface Response {
    fun <T> onSuccess(data: T)
    fun <T> onFailure(error: T)
}

class MainActivity : AppCompatActivity() {

    init {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var msg = ""
        var job = CoroutineScope(Dispatchers.IO).launch {
            val db = MovieDataBase.getInstance(applicationContext)
            db?.let{
                it.getUserDao().deleteUser(User(1,"","dc","",""))
                msg = it.getOrderDao().getUserSpecificOrder(1).size.toString()
//                val userId = it.getUserDao().insertUser(User(name = "name", phoneNO = "123456789", mailId = "ghiyiug", profilePicture = "khbjhhj"))
//                it.getUserCredentialDao().insertUserAccount(UserCredential(userId = userId, userName = "sampleum", password = "samplepwd"))
//                it.getOfferDao().insertOffer(Offer(userId=userId, brandName = "paytm", offerName = "cashback", promoCode = "promocode", validUpto = "2023"))
//                val movieId = it.getMovieDao().insertMovie(Movie(movieName = "unknown", language = "tamil", sensorCertificate = "U", synopsis = "a good movie", genre = "comedy", hero = "unknown", heroine = "unknown", villain = "unknown", releaseDate = "unknown", isFavouriteMovie = true))
//                val theatreId = it.getTheatreDao().insertTheatre(Theatre(theatreName = "rohini theatre", doorNo = "no25b", street = "street1", area = "wefhwge", city = "efouhwgf", isFavouriteTheatre = true))
//                val paymentId = it.getPaymentDao().insertPayment(Payment( gateWayName = "upi", status = "pending", referenceNo = "refno1", movieCost = 120.00, charges = 10.00, totalCost = 130.00))
//                it.getOrderDao().insertOrder(Order(userId = userId, movieId = movieId, theatreId = theatreId, paymentId = paymentId, screenName = "dummyscreen", ticketNo = "ticket1"))
//                msg = it.getOfferDao().getOffers(userId.toInt()).size.toString()
                withContext(Dispatchers.Main){  Toast.makeText(applicationContext,msg,Toast.LENGTH_LONG).show() }
            }

        }
    }


//    override fun <T> onSuccess(data: T) {
//        var msg = ""
//        msg = if (data is String) data else data.toString()
//        Toast.makeText(this.applicationContext, msg, Toast.LENGTH_SHORT).show()
//    }
//
//    override fun <T> onFailure(error: T) {
//
//    }

//    override fun onSuccess(data: String) {
//        Toast.makeText(this.applicationContext,data,Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onFailure(error: Throwable) {
//        Toast.makeText(this.applicationContext,error.message,Toast.LENGTH_SHORT).show()
//    }


}