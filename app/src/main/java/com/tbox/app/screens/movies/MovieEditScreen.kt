package com.tbox.app.screens.movies

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.models.Movie

@Composable
fun MovieEditScreen(
    movie: Movie? = null,
    onSave: (Movie) -> Unit
) {
    var title by remember { mutableStateOf(movie?.title ?: "") }
    var genre by remember { mutableStateOf(movie?.genre ?: "") }
    var description by remember { mutableStateOf(movie?.description ?: "") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = if (movie == null) "הוספת סרט" else "עריכת סרט", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("שם הסרט") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = genre, onValueChange = { genre = it }, label = { Text("ז'אנר") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = description, onValueChange = { description = it }, label = { Text("תיאור") }, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            onSave(Movie(id = movie?.id ?: System.currentTimeMillis().toInt(), title, genre, description))
        }, modifier = Modifier.fillMaxWidth()) {
            Text("שמור")
        }
    }
}
