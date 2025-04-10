package com.tbox.app.screens.admin.comments

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.models.Comment
import com.tbox.app.screens.admin.comments.components.CommentItemView
import com.tbox.app.viewmodels.CommentManager

@Composable
fun CommentsScreen() {
    val manager = remember { CommentManager() }
    var comments by remember { mutableStateOf(manager.getComments()) }

    Column(modifier = Modifier.padding(24.dp)) {
        Text("תגובות משתמשים", style = MaterialTheme.typography.headlineSmall)

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(comments.size) { index ->
                val comment = comments[index]
                CommentItemView(comment = comment) {
                    manager.deleteComment(comment.id)
                    comments = manager.getComments()
                }
            }
        }
    }
}
