package com.tbox.app.screens.movies

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tbox.app.model.Movie
import com.tbox.app.viewmodel.MovieViewModel

@Composable
fun AddMovieScreen(
    movieViewModel: MovieViewModel = viewModel(),
    onMovieAdded: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var desc by remember { mutableStateOf("") }
    var image by remember { mutableStateOf("") }
    var video by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("כותרת") })
        OutlinedTextField(value = desc, onValueChange = { desc = it }, label = { Text("תיאור") })
        OutlinedTextField(value = image, onValueChange = { image = it }, label = { Text("URL תמונה") })
        OutlinedTextField(value = video, onValueChange = { video = it }, label = { Text("URL סרטון") })

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val movie = Movie(
                id = (0..99999).random(),
                title = title,
                description = desc,
                imageUrl = image,
                videoUrl = video
            )
            movieViewModel.addMovie(movie)
            onMovieAdded()
        }) {
            Text("הוסף סרט")
        }
    }
}
