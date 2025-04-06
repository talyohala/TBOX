package com.tboxe.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tboxe.model.Movie
import com.tboxe.ui.screens.HomeScreen
import com.tboxe.ui.screens.MovieDetailScreen
import com.tboxe.ui.screens.MovieListScreen

@Composable
fun Navigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    movies: List<Movie>
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("movies") {
            MovieListScreen(navController = navController, movies = movies)
        }
        composable("detail/{movieId}") { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")
            val movie = movies.find { it.id == movieId }
            movie?.let {
                MovieDetailScreen(navController, it)
            }
        }
    }
}
