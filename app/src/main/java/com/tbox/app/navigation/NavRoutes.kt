package com.tbox.app.navigation

sealed class NavRoutes(val route: String) {
    object Login : NavRoutes("login")
    object Register : NavRoutes("register")
    object Profile : NavRoutes("profile")
    object Home : NavRoutes("home")
    object Movies : NavRoutes("movies")
    object Settings : NavRoutes("settings")
    object About : NavRoutes("about")
}
