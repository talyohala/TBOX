package com.tbox.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tbox.app.screens.auth.LoginScreen
import com.tbox.app.screens.auth.RegisterScreen
import com.tbox.app.screens.user.ProfileScreen
import com.tbox.app.screens.main.HomeScreen
import com.tbox.app.screens.movies.MoviesScreen
import com.tbox.app.screens.settings.SettingsScreen
import com.tbox.app.screens.settings.AboutScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoutes.Login.route) {
        composable(NavRoutes.Login.route) { LoginScreen(navController) }
        composable(NavRoutes.Register.route) { RegisterScreen(navController) }
        composable(NavRoutes.Profile.route) { ProfileScreen() }
        composable(NavRoutes.Home.route) { HomeScreen(navController) }
        composable(NavRoutes.Movies.route) { MoviesScreen(navController) }
        composable(NavRoutes.Settings.route) { SettingsScreen() }
        composable(NavRoutes.About.route) { AboutScreen() }
    }
}
