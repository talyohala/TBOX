package com.tbox.app.screens.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.tbox.app.models.Movie
import com.tbox.app.viewmodel.AdminViewModel

@Composable
fun EditContentScreen(
    viewModel: AdminViewModel,
    movieToEdit: Movie?,
    onSave: () -> Unit,
    onCancel: () -> Unit
) {
    var title by remember { mutableStateOf(TextFieldValue(movieToEdit?.title ?: "")) }
    var url by remember { mutableStateOf(TextFieldValue(movieToEdit?.url ?: "")) }
    var tag by remember { mutableStateOf(TextFieldValue(movieToEdit?.tag ?: "")) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("עריכת תוכן") })
        }
    ) { padding ->
        Column(modifier = Modifier
            .padding(padding)
            .padding(16.dp)) {

            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("שם הסרט") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = url,
                onValueChange = { url = it },
                label = { Text("קישור") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )

            OutlinedTextField(
                value = tag,
                onValueChange = { tag = it },
                label = { Text("תגית") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = onCancel) {
                    Text("ביטול")
                }
                Button(onClick = {
                    if (title.text.isNotBlank() && url.text.isNotBlank()) {
                        viewModel.saveMovie(
                            movieToEdit?.copy(
                                title = title.text,
                                url = url.text,
                                tag = tag.text
                            ) ?: Movie(title.text, url.text, tag.text)
                        )
                        onSave()
                    }
                }) {
                    Text("שמירה")
                }
            }
        }
    }
}
