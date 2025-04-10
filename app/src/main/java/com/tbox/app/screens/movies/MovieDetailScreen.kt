package com.tbox.app.screens.movies

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tbox.app.data.Movie
import com.tbox.app.navigation.Screen

@Composable
fun MovieDetailScreen(navController: NavController, movie: Movie?) {
    movie ?: return

    Column(modifier = Modifier.padding(24.dp)) {
        Text(text = movie.title, style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = movie.description, style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            navController.navigate("${Screen.EditMovie.route}/${movie.id}")
        }) {
            Text("ערוך סרט")
        }
    }
}
