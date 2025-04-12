package com.tbox.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tbox.app.screens.preview.ColorPreviewScreen

@Composable
fun AppNavHost(navController: NavHostController, startDestination: String = "colors") {
    NavHost(navController = navController, startDestination = startDestination) {
        composable("colors") {
            ColorPreviewScreen()
        }
    }
}
