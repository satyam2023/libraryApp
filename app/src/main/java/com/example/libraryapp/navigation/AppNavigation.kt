package com.example.libraryapp.navigation
import OnBoardingLayout
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.libraryapp.presentation.views.signIn.SignInScreen
import com.example.libraryapp.presentation.views.signUp.SignUpScreen
import com.example.libraryapp.ui.components.AppBottomBar

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navigationManager = NavControllerNavigationManager(navController)

    NavigationHandler.initialize(navigationManager)

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    CompositionLocalProvider(LocalNavigationManager provides navigationManager) {
        Scaffold(
            bottomBar = {
                if (!AppDestination.isAuthScreen(currentRoute)) {
                    AppBottomBar(currentRoute)
                }
            }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = AppDestination.OnBoarding.route,
                modifier = Modifier.padding(paddingValues)
            ) {

                composable(AppDestination.SignIn.route) {
                    SignInScreen()
                }
                composable(AppDestination.SignUp.route) {
                     SignUpScreen()
                }
                composable(AppDestination.OnBoarding.route) {
                    OnBoardingLayout(onBackClick = {}, onNextClick = {}, onSkipClick = {})
                }

                // Main content screens
                composable(AppDestination.Home.route) {
                    // HomeScreen()
                }
                composable(AppDestination.Library.route) {
                    // LibraryScreen()
                }
                composable(AppDestination.Profile.route) {
                    // ProfileScreen()
                }
            }
        }
    }
}