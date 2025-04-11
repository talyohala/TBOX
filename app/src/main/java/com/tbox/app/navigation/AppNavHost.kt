package com.tbox.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tbox.app.screens.tags.TagScreen

@Composable
fun AppNavHost(navController: NavHostController, startDestination: String = "tags") {
    NavHost(navController = navController, startDestination = startDestination) {
        composable("tags") {
            TagScreen()
        }

        // בעתיד תוכל להוסיף כאן עוד:
        // composable("movies") { MovieScreen() }
        // composable("profile") { ProfileScreen() }
    }
}
