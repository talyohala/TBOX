package com.myflix.app.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.myflix.app.ui.screens.*

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(onNavigate = { navController.navigate(it) }) }
        composable("hot") { HotMoviesScreen() }
        composable("favorites") { FavoritesScreen() }
        composable("live") { LiveStreamScreen() }
        composable("admin") { AdminScreen() }
    }
}
