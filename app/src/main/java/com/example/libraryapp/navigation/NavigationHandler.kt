
package com.example.libraryapp.navigation

object NavigationHandler {
    private var navigationManager: NavigationManager? = null

    fun initialize(navigationManager: NavigationManager) {
        this.navigationManager = navigationManager
    }

    fun navigateTo(destination: AppDestination) {
        navigationManager?.navigateTo(destination)
    }

    fun navigateToAuth() {
        navigationManager?.navigateToAuth()
    }

    fun navigateToMain() {
        navigationManager?.navigateToMain()
    }
}