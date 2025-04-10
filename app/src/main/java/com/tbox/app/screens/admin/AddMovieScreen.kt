package com.tbox.app.screens.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddMovieScreen(navController: NavController) {
    var title by remember { mutableStateOf("") }
    var link by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("הוספת סרט חדש", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("שם הסרט") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = link,
            onValueChange = { link = it },
            label = { Text("קישור") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                // TODO: שליחה לשרת/שמירה במסד נתונים
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("שמור")
        }
    }
}
