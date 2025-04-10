package com.tbox.app.screens.movies

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tbox.app.data.Movie
import com.tbox.app.navigation.Screen

@Composable
fun MovieListScreen(navController: NavController, movies: List<Movie>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("רשימת סרטים", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(movies) { movie ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .clickable {
                            navController.navigate("${Screen.MovieDetail.route}/${movie.id}")
                        }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = movie.title, style = MaterialTheme.typography.titleLarge)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = movie.description.take(60) + "...", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
