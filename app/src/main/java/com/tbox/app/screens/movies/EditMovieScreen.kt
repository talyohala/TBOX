package com.tbox.app.screens.movies

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tbox.app.data.Movie

@Composable
fun EditMovieScreen(navController: NavController, existingMovie: Movie? = null) {
    var title by remember { mutableStateOf(existingMovie?.title ?: "") }
    var description by remember { mutableStateOf(existingMovie?.description ?: "") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {

        Text(text = if (existingMovie != null) "עריכת סרט" else "הוספת סרט", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("שם הסרט") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("תיאור") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (title.isNotBlank() && description.isNotBlank()) {
                    // שמירה למסד נתונים או API תבוא כאן
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("שמור")
        }
    }
}
