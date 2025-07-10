package com.example.libraryapp.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.libraryapp.R
import com.example.libraryapp.navigation.AppDestination
import com.example.libraryapp.navigation.LocalNavigationManager

@Composable
fun AppBottomBar(currentRoute: String?) {
    val navigationManager = LocalNavigationManager.current

    NavigationBar {
    }
}