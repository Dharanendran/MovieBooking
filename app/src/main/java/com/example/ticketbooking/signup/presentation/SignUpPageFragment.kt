package com.example.ticketbooking.signup.presentation

import android.content.Context
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ticketbooking.R
import com.example.ticketbooking.databinding.FragmentSignUpBinding
import com.example.ticketbooking.dependencyInjection.DependencyFactory
import com.example.ticketbooking.MainActivity

class SignUpPageFragment:Fragment(), SignUpPageViewModel.ToastMaker {

    private lateinit var fragmentSignUpBinding:FragmentSignUpBinding
    private lateinit var viewModel: SignUpPageViewModel
    private lateinit var activityContext:Context


    override fun onResume(){
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.title = "New Account"
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        activityContext = activity?.applicationContext as Context

        viewModel = ViewModelProvider(activity as MainActivity)[SignUpPageViewModel::class.java].apply {
            toastMaker = this@SignUpPageFragment
            userNameExistCheckingUseCase = DependencyFactory.getInstance(activityContext).getUserNameExistCheckingUseCase( DependencyFactory.getInstance(activityContext).getIsUserNameExistRepositoryImpl() )
            createUserAccountUseCase = DependencyFactory.getInstance(activityContext).getCreateUserAccountUseCase( DependencyFactory.getInstance(activityContext).getCreateUserAccountRepositoryImpl() )
        }

        fragmentSignUpBinding = DataBindingUtil.inflate<FragmentSignUpBinding?>(inflater, R.layout.fragment_sign_up, container, false).apply {
            viewModel = this@SignUpPageFragment.viewModel
            lifecycleOwner = this@SignUpPageFragment
        }

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).fragmentRemovable = this

        return fragmentSignUpBinding.root
    }


    override fun makeToast(message: String) { // also we can use live data for that
        Toast.makeText(activityContext, message, Toast.LENGTH_SHORT).show()
    }


}


