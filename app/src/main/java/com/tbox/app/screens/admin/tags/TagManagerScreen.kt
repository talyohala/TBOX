package com.tbox.app.screens.admin.tags

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tbox.app.models.Tag
import com.tbox.app.screens.admin.tags.components.TagItemView
import com.tbox.app.viewmodels.TagViewModel

@Composable
fun TagManagerScreen(viewModel: TagViewModel = viewModel()) {
    val tags by viewModel.tags.collectAsState()
    var newTagName by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("ניהול תגיות", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(12.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = newTagName,
                onValueChange = { newTagName = it },
                label = { Text("שם תגית חדשה") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                if (newTagName.isNotBlank()) {
                    viewModel.addTag(Tag(name = newTagName))
                    newTagName = ""
                }
            }) {
                Text("הוסף")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        tags.forEach { tag ->
            TagItemView(tag = tag, onDelete = { viewModel.deleteTag(tag) })
        }
    }
}
