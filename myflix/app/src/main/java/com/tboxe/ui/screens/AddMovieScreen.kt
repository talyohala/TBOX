package com.tboxe.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tboxe.viewmodel.MovieViewModel

@Composable
fun AddMovieScreen(navController: NavController, movieViewModel: MovieViewModel) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var streamUrl by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("➕ הוספת סרט חדש") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("שם הסרט") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("תיאור קצר") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = streamUrl,
                onValueChange = { streamUrl = it },
                label = { Text("קישור m3u8") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    val success = movieViewModel.addMovie(title, description, streamUrl)
                    message = if (success) {
                        title = ""
                        description = ""
                        streamUrl = ""
                        "✅ הסרט נוסף בהצלחה"
                    } else {
                        "❌ שגיאה בהוספת הסרט"
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("שמור סרט")
            }

            if (message.isNotEmpty()) {
                Text(text = message)
            }
        }
    }
}
