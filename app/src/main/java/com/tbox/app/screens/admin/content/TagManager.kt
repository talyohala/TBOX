package com.tbox.app.screens.admin.content

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign

@Composable
fun TagManager(
    tags: List<String>,
    onAddTag: (String) -> Unit,
    onRemoveTag: (String) -> Unit
) {
    var tagInput by remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("ניהול תגיות", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            BasicTextField(
                value = tagInput,
                onValueChange = { tagInput = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .border(1.dp, MaterialTheme.colorScheme.primary, shape = MaterialTheme.shapes.small)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                val tag = tagInput.text.trim()
                if (tag.isNotEmpty()) {
                    onAddTag(tag)
                    tagInput = TextFieldValue("")
                }
            }) {
                Text("הוסף")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        if (tags.isEmpty()) {
            Text("אין תגיות כרגע.", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        } else {
            Column {
                tags.forEach { tag ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = tag, modifier = Modifier.weight(1f))
                        IconButton(onClick = { onRemoveTag(tag) }) {
                            Icon(Icons.Default.Delete, contentDescription = "מחק תגית")
                        }
                    }
                }
            }
        }
    }
}
