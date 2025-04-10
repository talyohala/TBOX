package com.tbox.app.screens.admin.comments.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.models.Comment

@Composable
fun CommentItemView(
    comment: Comment,
    onDelete: () -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp)) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = "${comment.userName} אמר:", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = comment.text, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onDelete) {
                Text("מחק תגובה")
            }
        }
    }
}
