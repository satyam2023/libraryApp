package com.example.libraryapp.presentation.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.libraryapp.data.SignInFields
import com.example.libraryapp.navigation.AppDestination
import com.example.libraryapp.navigation.NavigationHandler

class SignInViewModel : ViewModel() {
    val signInPlaceholder=SignInFields;
    val signInValue = mutableStateListOf(*Array(SignInFields.size) { "" })

    fun handleEnteredCreds(value: String, index: Int) {
        signInValue[index] = value;
    }

    fun handleSignIn() {

    }

    fun navigateToSignUp() {
NavigationHandler.navigateTo(AppDestination.SignUp)
    }
}