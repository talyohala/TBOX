package com.tbox.app.screens.admin.content

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.tbox.app.model.Movie
import com.tbox.app.viewmodel.ContentViewModel

@Composable
fun EditMovieDialog(
    movie: Movie,
    onDismiss: () -> Unit,
    onConfirm: (Movie) -> Unit,
    viewModel: ContentViewModel
) {
    var title by remember { mutableStateOf(TextFieldValue(movie.title)) }
    var url by remember { mutableStateOf(TextFieldValue(movie.url)) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("עריכת סרט") },
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
                    val updatedMovie = movie.copy(
                        title = title.text,
                        url = url.text
                    )
                    onConfirm(updatedMovie)
                }
            ) {
                Text("שמור")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("ביטול")
            }
        }
    )
}
