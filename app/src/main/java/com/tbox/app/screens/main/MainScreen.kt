package com.tbox.app.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tbox.app.ui.components.FeaturedSection
import com.tbox.app.ui.components.MovieRow
import com.tbox.app.viewmodel.MovieViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: MovieViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("TBOX - סרטים") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(8.dp)
        ) {
            FeaturedSection(viewModel.featuredMovie, navController)

            Spacer(modifier = Modifier.height(16.dp))

            MovieRow(
                title = "המלצות חמות",
                movies = viewModel.recommendedMovies,
                navController = navController
            )

            Spacer(modifier = Modifier.height(16.dp))

            MovieRow(
                title = "הנצפים ביותר",
                movies = viewModel.popularMovies,
                navController = navController
            )
        }
    }
}
