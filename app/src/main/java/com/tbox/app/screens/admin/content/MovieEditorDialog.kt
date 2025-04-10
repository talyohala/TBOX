package com.tbox.app.screens.admin.content

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.models.Movie

@Composable
fun MovieEditorDialog(
    initialMovie: Movie?,
    onConfirm: (Movie) -> Unit,
    onDismiss: () -> Unit
) {
    var title by remember { mutableStateOf(initialMovie?.title ?: "") }
    var url by remember { mutableStateOf(initialMovie?.url ?: "") }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = {
                    if (title.isNotBlank() && url.isNotBlank()) {
                        onConfirm(Movie(title = title.trim(), url = url.trim()))
                    }
                }
            ) {
                Text("שמור")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("ביטול")
            }
        },
        title = { Text(if (initialMovie == null) "הוספת סרט חדש" else "עריכת סרט") },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
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
                    label = { Text("קישור לסרט") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    )
}
