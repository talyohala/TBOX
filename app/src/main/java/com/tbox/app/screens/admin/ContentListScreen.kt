package com.tbox.app.screens.admin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.models.Movie
import com.tbox.app.viewmodel.AdminViewModel

@Composable
fun ContentListScreen(viewModel: AdminViewModel, onEditMovie: (Movie) -> Unit) {
    val movies by viewModel.movieList.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("ניהול סרטים") })
        }
    ) { padding ->
        if (movies.isEmpty()) {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("אין סרטים להצגה.")
            }
        } else {
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(movies) { movie ->
                    MovieItem(movie, onEditMovie, viewModel::deleteMovie)
                }
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie, onEdit: (Movie) -> Unit, onDelete: (Movie) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onEdit(movie) },
        elevation = CardDefaults.cardElevation()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = movie.title, style = MaterialTheme.typography.titleMedium)
                Text(text = "תגית: ${movie.tag}", style = MaterialTheme.typography.bodySmall)
            }
            IconButton(onClick = { onDelete(movie) }) {
                Icon(Icons.Default.Delete, contentDescription = "מחיקה")
            }
        }
    }
}
