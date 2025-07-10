package com.example.libraryapp.navigation

sealed class AppDestination(val route: String) {

    object SignIn : AppDestination("signIn")
    object SignUp : AppDestination("signUp")
    object ForgotPassword : AppDestination("forgotPassword")
    object OnBoarding : AppDestination("onBoarding")


    object Home : AppDestination("home")
    object Library : AppDestination("library")
    object Profile : AppDestination("profile")

    companion object {
        val authScreens = listOf(SignIn.route, SignUp.route, ForgotPassword.route,OnBoarding.route)
        fun isAuthScreen(route: String?): Boolean = route in authScreens
    }
}