package com.tbox.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tbox.app.screens.main.HomeScreen
import com.tbox.app.screens.user.ProfileScreen
import com.tbox.app.screens.user.LoginScreen
import com.tbox.app.screens.user.RegisterScreen

@Composable
fun NavGraph(navController: NavHostController, startDestination: String = "home") {
    NavHost(navController = navController, startDestination = startDestination) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("profile") {
            ProfileScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("register") {
            RegisterScreen(navController)
        }
    }
}
