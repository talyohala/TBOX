package com.tbox.app.screens.admin.comments.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddCommentForm(
    onSubmit: (String, String) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("שם") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("תגובה") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                if (name.isNotBlank() && text.isNotBlank()) {
                    onSubmit(name, text)
                    name = ""
                    text = ""
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("שלח תגובה")
        }
    }
}
