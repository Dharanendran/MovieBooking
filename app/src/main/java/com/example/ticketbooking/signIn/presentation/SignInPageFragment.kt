package com.example.ticketbooking.signIn.presentation

import android.app.Activity.RESULT_OK
import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.ticketbooking.R
import com.example.ticketbooking.databinding.FragmentLoginBinding
import com.example.ticketbooking.dependencyInjection.DependencyFactory
import com.example.ticketbooking.MainActivity
import com.example.ticketbooking.dataRepository.roomDatabase.entities.User
import com.example.ticketbooking.signup.presentation.SignUpPageFragment
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream


class SignInPageFragment : Fragment(), SignInPageViewModel.ToastMaker {

    private lateinit var activityContext: Context
    private lateinit var fragmentLoginBinding: FragmentLoginBinding
    private lateinit var viewModel: SignInPageViewModel

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                try {

                    val account = task.result
                    Toast.makeText(activityContext, "${account.email}", Toast.LENGTH_SHORT).show()

                    val name = account.displayName.toString()
                    val phoneNo = ""
                    val email = account.email.toString()
                    val profilePicture:ByteArray? = account.photoUrl?.let{
                        val inputStream = context?.contentResolver?.openInputStream(it)
                        val bitmap = Glide.with(activityContext).asBitmap().load(inputStream).submit().get()
                        val outPutStream = ByteArrayOutputStream()
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outPutStream)
                        outPutStream.toByteArray()
                    }

                    viewModel.createUserAccountUseCase?.createAccount(User(name, phoneNo, email, profilePicture), "", ""){
                        Toast.makeText(activityContext, "logged in successFull", Toast.LENGTH_SHORT).show()
                    }

                    viewModel.setIsLoginSuccessFull(true)

                }
                catch (e: ApiException) {
                    Toast.makeText(activityContext, "failure", Toast.LENGTH_SHORT).show()
                }
            }
        }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
        (activity as MainActivity).findViewById<BottomNavigationView>(R.id.bottomNavigationView)?.visibility = View.GONE
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        activityContext = activity?.applicationContext as Context

        viewModel = ViewModelProvider(this)[SignInPageViewModel::class.java].apply {

            toastMaker = this@SignInPageFragment
            isUserExistUseCase = DependencyFactory.getInstance(activityContext)
                .getIsUserExistUseCase( DependencyFactory.getInstance(activityContext).getIsUserExistRepositoryImpl())
            createUserAccountUseCase = DependencyFactory.getInstance(activityContext)
                .getCreateUserAccountUseCase(DependencyFactory.getInstance(activityContext).getCreateUserAccountRepositoryImpl())
        }


        fragmentLoginBinding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login,
            container,
            false
        ).apply {
            viewModel = this@SignInPageFragment.viewModel
            lifecycleOwner = this@SignInPageFragment
        }


        viewModel.isLoginSuccessFull().observe(viewLifecycleOwner, Observer {

            if (it) {
                Toast.makeText(activityContext, "SuccessFully Logged", Toast.LENGTH_SHORT).show()
//                (activity as MainActivity).fragmentTransactionProcess(false, SignUpPageFragment::class.simpleName, SignUpPageFragment() )
            }
        }
        )

        viewModel.isSignUpClicked().observe(viewLifecycleOwner, Observer {

            if (it)
                (activity as MainActivity).fragmentTransactionProcess(
                    true,
                    SignUpPageFragment::class.simpleName,
                    SignUpPageFragment()
                )

        })


        viewModel.isProgressBarStarted().observe(viewLifecycleOwner, Observer {

            if (it) {
                fragmentLoginBinding.signInProgressBar.visibility = View.VISIBLE
                fragmentLoginBinding.overlapView.visibility = View.VISIBLE
            } else {
                fragmentLoginBinding.signInProgressBar.visibility = View.GONE
                fragmentLoginBinding.overlapView.visibility = View.GONE
            }
        })


        viewModel.isGoogleSignInClicked().observe(this.viewLifecycleOwner, Observer {
            if (it)
                googleSignInActivity()
        })

        return fragmentLoginBinding.root

    }

    private fun googleSignInActivity() {
        CoroutineScope(Dispatchers.Main).launch {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
            val googleSignInClient = GoogleSignIn.getClient(activityContext, gso)
            val signInIntent = googleSignInClient.signInIntent
            startForResult.launch(signInIntent)
        }
    }

    override fun makeToast(message: String) { // also we can use Live data for this
        Toast.makeText(activityContext, message, Toast.LENGTH_SHORT).show()
    }

}