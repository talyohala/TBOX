package com.tbox.app.screens.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EditMovieScreen() {
    var movieId by remember { mutableStateOf("") }
    var newTitle by remember { mutableStateOf("") }
    var newUrl by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("עריכת סרט קיים", style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = movieId,
            onValueChange = { movieId = it },
            label = { Text("מזהה הסרט") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = newTitle,
            onValueChange = { newTitle = it },
            label = { Text("שם חדש") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = newUrl,
            onValueChange = { newUrl = it },
            label = { Text("קישור חדש") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        Button(
            onClick = {
                // TODO: עדכון הסרט לפי ID
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("עדכן")
        }
    }
}
