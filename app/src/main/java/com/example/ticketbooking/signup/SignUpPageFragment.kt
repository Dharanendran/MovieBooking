package com.example.ticketbooking.signup

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
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
import com.example.ticketbooking.signIn.MainActivity

class SignUpPageFragment:Fragment(),SignUpPageViewModel.ToastMaker {

    private lateinit var fragmentSignUpBinding:FragmentSignUpBinding
    private lateinit var viewModel:SignUpPageViewModel
    private lateinit var activityContext:Context

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.show()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        activityContext = activity?.applicationContext as Context

        viewModel = ViewModelProvider(activity as MainActivity)[SignUpPageViewModel::class.java].apply {
            toastMaker = this@SignUpPageFragment
            repository = DependencyFactory.getInstance(activityContext).getSignUpPageRepository()
        }

        fragmentSignUpBinding = DataBindingUtil.inflate<FragmentSignUpBinding?>(inflater, R.layout.fragment_sign_up, container, false).apply {
            viewModel = this@SignUpPageFragment.viewModel
            lifecycleOwner = this@SignUpPageFragment
        }

        return fragmentSignUpBinding.root
    }

    override fun makeToast(message: String) {
        Toast.makeText(activityContext, message, Toast.LENGTH_SHORT).show()
    }


}


