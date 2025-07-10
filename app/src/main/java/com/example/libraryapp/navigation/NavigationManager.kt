package com.example.libraryapp.navigation

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController

interface NavigationManager {
    fun navigateTo(destination: AppDestination)
    fun navigateToAuth()
    fun navigateToMain()
}

class NavControllerNavigationManager(private val navController: NavHostController) : NavigationManager {
    override fun navigateTo(destination: AppDestination) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.startDestinationId) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }

    override fun navigateToAuth() {
        navController.navigate(AppDestination.SignIn.route) {
            popUpTo(0) { inclusive = true }
        }
    }

    override fun navigateToMain() {
        navController.navigate(AppDestination.Home.route) {
            popUpTo(0) { inclusive = true }
        }
    }
}

val LocalNavigationManager = compositionLocalOf<NavigationManager> {
    error("NavigationManager not provided")
}