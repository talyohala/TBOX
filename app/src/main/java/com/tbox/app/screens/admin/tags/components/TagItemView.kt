package com.tbox.app.screens.admin.tags.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.models.Tag

@Composable
fun TagItemView(
    tag: Tag,
    onDelete: () -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp)) {
        Row(modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = tag.name, style = MaterialTheme.typography.bodyLarge)
            Button(onClick = onDelete) {
                Text("מחק")
            }
        }
    }
}
