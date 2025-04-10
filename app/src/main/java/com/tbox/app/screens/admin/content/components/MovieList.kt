package com.tbox.app.screens.admin.content.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.model.Movie
import com.tbox.app.screens.admin.content.ContentViewModel

@Composable
fun MovieList(
    movies: List<Movie>,
    viewModel: ContentViewModel,
    onEdit: (Movie) -> Unit,
    onDelete: (Movie) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(movies) { movie ->
            MovieItemView(
                movie = movie,
                onEdit = { onEdit(movie) },
                onDelete = { onDelete(movie) },
                viewModel = viewModel
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
