package com.tbox.app.screens.admin.content

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.tbox.app.model.Movie

@Composable
fun EditMovieScreen(
    movie: Movie,
    onSave: (Movie) -> Unit,
    onCancel: () -> Unit
) {
    var title by remember { mutableStateOf(TextFieldValue(movie.title)) }
    var description by remember { mutableStateOf(TextFieldValue(movie.description)) }
    var imageUrl by remember { mutableStateOf(TextFieldValue(movie.imageUrl)) }
    var streamUrl by remember { mutableStateOf(TextFieldValue(movie.streamUrl)) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("עריכת סרט", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        MovieTextField("שם הסרט", title) { title = it }
        Spacer(modifier = Modifier.height(8.dp))

        MovieTextField("תיאור", description) { description = it }
        Spacer(modifier = Modifier.height(8.dp))

        MovieTextField("קישור תמונה", imageUrl) { imageUrl = it }
        Spacer(modifier = Modifier.height(8.dp))

        MovieTextField("קישור לצפייה", streamUrl) { streamUrl = it }
        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = onCancel) {
                Text("ביטול")
            }
            Button(onClick = {
                onSave(
                    movie.copy(
                        title = title.text.trim(),
                        description = description.text.trim(),
                        imageUrl = imageUrl.text.trim(),
                        streamUrl = streamUrl.text.trim()
                    )
                )
            }) {
                Text("שמור")
            }
        }
    }
}

@Composable
fun MovieTextField(label: String, value: TextFieldValue, onChange: (TextFieldValue) -> Unit) {
    Column {
        Text(text = label, style = MaterialTheme.typography.bodyMedium)
        BasicTextField(
            value = value,
            onValueChange = onChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary, shape = MaterialTheme.shapes.small)
                .padding(8.dp)
        )
    }
}
