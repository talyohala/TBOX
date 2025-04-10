package com.tbox.app.screens.admin.content.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.model.Movie

@Composable
fun MovieEditDialog(
    movie: Movie,
    onDismiss: () -> Unit,
    onSave: (Movie) -> Unit
) {
    var title by remember { mutableStateOf(movie.title) }
    var description by remember { mutableStateOf(movie.description) }
    var imageUrl by remember { mutableStateOf(movie.imageUrl) }
    var videoUrl by remember { mutableStateOf(movie.videoUrl) }
    var tags by remember { mutableStateOf(movie.tags.joinToString(", ")) }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = {
                onSave(
                    movie.copy(
                        title = title,
                        description = description,
                        imageUrl = imageUrl,
                        videoUrl = videoUrl,
                        tags = tags.split(",").map { it.trim() }
                    )
                )
            }) {
                Text("שמור")
            }
        },
        dismissButton = {
            OutlinedButton(onClick = onDismiss) {
                Text("ביטול")
            }
        },
        title = { Text("עריכת סרט") },
        text = {
            Column(modifier = Modifier.fillMaxWidth().padding(4.dp)) {
                OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("שם הסרט") }, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(4.dp))
                OutlinedTextField(value = description, onValueChange = { description = it }, label = { Text("תיאור") }, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(4.dp))
                OutlinedTextField(value = imageUrl, onValueChange = { imageUrl = it }, label = { Text("קישור לתמונה") }, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(4.dp))
                OutlinedTextField(value = videoUrl, onValueChange = { videoUrl = it }, label = { Text("קישור לסרטון") }, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(4.dp))
                OutlinedTextField(value = tags, onValueChange = { tags = it }, label = { Text("תגיות (מופרדות בפסיק)") }, modifier = Modifier.fillMaxWidth())
            }
        }
    )
}
