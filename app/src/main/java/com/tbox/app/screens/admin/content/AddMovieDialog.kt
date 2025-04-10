package com.tbox.app.screens.admin.content

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.tbox.app.model.Movie
import java.util.*

@Composable
fun AddMovieDialog(
    onDismiss: () -> Unit,
    onAddMovie: (Movie) -> Unit
) {
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var url by remember { mutableStateOf(TextFieldValue("")) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("הוספת סרט חדש") },
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
                    label = { Text("קישור הסרט") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (title.text.isNotBlank() && url.text.isNotBlank()) {
                        onAddMovie(
                            Movie(
                                id = UUID.randomUUID().toString(),
                                title = title.text.trim(),
                                url = url.text.trim()
                            )
                        )
                        onDismiss()
                    }
                }
            ) {
                Text("הוסף")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("ביטול")
            }
        }
    )
}
