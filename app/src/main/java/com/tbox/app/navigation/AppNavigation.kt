package com.tbox.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tbox.app.screens.main.MainScreen
import com.tbox.app.screens.user.ProfileScreen
import com.tbox.app.screens.movies.MovieScreen
import com.tbox.app.screens.auth.LoginScreen
import com.tbox.app.screens.auth.RegisterScreen
import com.tbox.app.screens.admin.AdminDashboardScreen

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("movies") { MovieScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("admin") { AdminDashboardScreen(navController) }
    }
}
