package com.tbox.app.screens.admin.content

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.model.Movie
import com.tbox.app.screens.admin.content.components.MovieEditor
import com.tbox.app.screens.admin.content.components.MovieItemView

@Composable
fun ContentManagementScreen(viewModel: ContentViewModel = ContentViewModel()) {
    val movies = viewModel.movieList
    val selected = viewModel.selectedMovie

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "ניהול תוכן",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        MovieEditor(
            selectedMovie = selected,
            onSave = { movie ->
                if (selected != null) {
                    viewModel.updateMovie(movie)
                } else {
                    viewModel.addMovie(movie)
                }
                viewModel.clearSelection()
            },
            onCancel = { viewModel.clearSelection() }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("רשימת סרטים", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(8.dp))

        movies.forEach { movie ->
            MovieItemView(
                movie = movie,
                onEdit = { viewModel.selectMovie(it) },
                onDelete = { viewModel.deleteMovie(it) }
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}
