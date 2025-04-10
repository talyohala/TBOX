package com.tbox.app.screens.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DeleteMovieScreen() {
    var movieId by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("מחיקת סרט", style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = movieId,
            onValueChange = { movieId = it },
            label = { Text("מזהה הסרט למחיקה") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        Button(
            onClick = {
                // TODO: מחיקת הסרט לפי ID
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("מחק")
        }
    }
}
