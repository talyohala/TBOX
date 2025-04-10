package com.tbox.app.screens.admin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.models.Movie

@Composable
fun ManageMoviesScreen(movies: List<Movie>, onDelete: (Movie) -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("ניהול סרטים", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(movies) { movie ->
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("שם: ${movie.title}")
                            Text("ז'אנר: ${movie.genre}")
                        }
                        Button(onClick = { onDelete(movie) }) {
                            Text("מחק")
                        }
                    }
                }
            }
        }
    }
}
