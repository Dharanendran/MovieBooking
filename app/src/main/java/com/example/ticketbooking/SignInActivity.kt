package com.example.ticketbooking

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.internal.Objects.ToStringHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SignInActivity : AppCompatActivity() {

    enum class SignInActivityResult(var code: Int) {
        RESULT_CODE1(1), RESULT_CODE2(2), RESULT_CODE3(3), RESULT_CODE4(4)
    }

    private lateinit var signInButton: Button
    private lateinit var googleSignInButton: Button
    private var userNameFromGoogleSignIn: String = ""
    private var userIdFromGoogleSignIn: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)


        signInButton = findViewById(R.id.signInButton)
        googleSignInButton = findViewById(R.id.googleSignInButton)

        googleSignInButton.setOnClickListener {

            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
            val googleSignInClient = GoogleSignIn.getClient(this@SignInActivity, gso)
            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, SignInActivityResult.RESULT_CODE1.code)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == SignInActivityResult.RESULT_CODE1.code) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.result
                Toast.makeText(this@SignInActivity, "${account.email}", Toast.LENGTH_SHORT).show()
            } catch (e: ApiException) {
                Toast.makeText(this@SignInActivity, "failure", Toast.LENGTH_SHORT).show()

            }
        }
    }

}
