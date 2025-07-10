package com.example.libraryapp.presentation.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.libraryapp.data.SignUpFields
import com.example.libraryapp.navigation.AppDestination
import com.example.libraryapp.navigation.NavigationHandler


class SignUpViewModel:ViewModel() {
    val signUpPlaceholder= SignUpFields;
    val signUpValue = mutableStateListOf(*Array(SignUpFields.size) { "" });

    fun handleEnteredData(value: String, index: Int) {
        signUpValue[index] = value;
    }
    fun handleSignUp(){

    }

    fun navigateToSignIn() {
       NavigationHandler.navigateTo(AppDestination.SignIn)
    }
}