package com.example.ticketbooking.signIn


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.*
import androidx.lifecycle.*
import com.example.ticketbooking.R
import com.example.ticketbooking.databinding.FragmentLoginBinding
import com.example.ticketbooking.dependencyInjection.DependencyFactory
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException

//interface Response {
//    fun <T> onSuccess(data: T)
//    fun <T> onFailure(error: T)
//}

//var isDarkModeEnabled  = false


class MainActivity : AppCompatActivity(), SignInPageViewModel.ToastMaker {

    lateinit var fragmentLoginBinding: FragmentLoginBinding
    private lateinit var viewModel: SignInPageViewModel
    private val fragmentManager = supportFragmentManager

    companion object {
        private const val RESULT_CODE_GOOGLE_SIGN_IN = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        fragmentLoginBinding = DataBindingUtil.setContentView(this, R.layout.fragment_login)

        supportActionBar?.hide()

        viewModel = ViewModelProvider(this)[SignInPageViewModel::class.java]

        viewModel.toastMaker = this
        viewModel.repository =
            DependencyFactory.getInstance(this.applicationContext).getSignInPageRepository()

        fragmentLoginBinding.viewModel = viewModel
        fragmentLoginBinding.lifecycleOwner = this

        viewModel.isLoginSuccessFull().observe(this, Observer {
            if (it) {
//                val transaction = fragmentManager.beginTransaction()
                Toast.makeText(this, "activity started", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.isProgressBarStarted().observe(this, Observer {
            if (it)
            {
                fragmentLoginBinding.signInProgressBar.visibility = View.VISIBLE
                fragmentLoginBinding.overlapView.visibility = View.VISIBLE
            }
            else
            {
                fragmentLoginBinding.signInProgressBar.visibility = View.GONE
                fragmentLoginBinding.overlapView.visibility = View.GONE
            }
        })



        fragmentLoginBinding.googleSignInButton.setOnClickListener {

            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
            val googleSignInClient = GoogleSignIn.getClient(this.applicationContext, gso)
            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, RESULT_CODE_GOOGLE_SIGN_IN)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == RESULT_CODE_GOOGLE_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.result
                Toast.makeText(this.applicationContext, "${account.email}", Toast.LENGTH_SHORT)
                    .show()
                viewModel.setIsLoginSuccessFull(true)
            } catch (e: ApiException) {
                Toast.makeText(this.applicationContext, "failure", Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun makeToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
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