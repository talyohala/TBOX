package com.tbox.app.screens.tags

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tbox.app.models.Tag
import com.tbox.app.viewmodels.TagViewModel

@Composable
fun TagScreen(
    tagViewModel: TagViewModel = viewModel()
) {
    val tags by tagViewModel.tags.collectAsState()

    var newTagName by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("ניהול תגיות", style = MaterialTheme.typography.headlineSmall)

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
                value = newTagName,
                onValueChange = { newTagName = it },
                label = { Text("תגית חדשה") },
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = {
                    if (newTagName.isNotBlank()) {
                        tagViewModel.addTag(Tag(name = newTagName))
                        newTagName = ""
                    }
                }
            ) {
                Text("הוסף")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(tags) { tag ->
                TagItem(tag = tag, onDelete = { tagViewModel.deleteTag(tag) })
            }
        }
    }
}

@Composable
fun TagItem(tag: Tag, onDelete: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = tag.name)
            TextButton(onClick = onDelete) {
                Text("מחק", color = MaterialTheme.colorScheme.error)
            }
        }
    }
}
