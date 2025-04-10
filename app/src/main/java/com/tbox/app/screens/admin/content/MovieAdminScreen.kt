package com.tbox.app.screens.admin.content

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.models.Movie
import com.tbox.app.viewmodel.AdminContentViewModel

@Composable
fun MovieAdminScreen(viewModel: AdminContentViewModel) {
    val movies by viewModel.movieList.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("ניהול סרטים", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { viewModel.startAddingMovie() }) {
            Text("הוסף סרט חדש")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(movies) { movie ->
                MovieAdminItem(
                    movie = movie,
                    onEdit = { viewModel.startEditingMovie(movie) },
                    onDelete = { viewModel.deleteMovie(movie) }
                )
                Divider()
            }
        }
    }

    if (viewModel.showEditorDialog) {
        MovieEditorDialog(viewModel = viewModel)
    }
}
