package com.tbox.app.screens.admin.content.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.model.Movie

@Composable
fun MovieFormDialog(
    movie: Movie?,
    onConfirm: (Movie) -> Unit,
    onDismiss: () -> Unit
) {
    var title by remember { mutableStateOf(movie?.title ?: "") }
    var url by remember { mutableStateOf(movie?.url ?: "") }
    var tags by remember { mutableStateOf(movie?.tags ?: "") }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(if (movie == null) "הוספת סרט" else "עריכת סרט") },
        text = {
            Column {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("שם הסרט") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = url,
                    onValueChange = { url = it },
                    label = { Text("קישור לצפייה") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = tags,
                    onValueChange = { tags = it },
                    label = { Text("תגיות (מופרדות בפסיק)") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                onConfirm(Movie(title, url, tags))
            }) {
                Text("שמור")
            }
        },
        dismissButton = {
            OutlinedButton(onClick = { onDismiss() }) {
                Text("ביטול")
            }
        }
    )
}
