package com.tbox.app.screens.user

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tbox.app.ui.components.AppTopBar
import com.tbox.app.models.Movie

@Composable
fun FavoritesScreen(navController: NavController, favorites: List<Movie>) {
    Scaffold(
        topBar = {
            AppTopBar(title = "מועדפים") {
                navController.popBackStack()
            }
        }
    ) { padding ->
        if (favorites.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("אין סרטים מועדפים עדיין.")
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(padding)
            ) {
                items(favorites) { movie ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate("movieDetail/${movie.id}")
                            }
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = movie.title, style = MaterialTheme.typography.titleMedium)
                            Text(text = movie.description, maxLines = 2)
                        }
                    }
                }
            }
        }
    }
}
