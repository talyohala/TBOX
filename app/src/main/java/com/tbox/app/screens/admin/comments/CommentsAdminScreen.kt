package com.tbox.app.screens.admin.comments

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tbox.app.models.Comment
import com.tbox.app.screens.admin.comments.components.AddCommentForm
import com.tbox.app.screens.admin.comments.components.CommentItemView

@Composable
fun CommentsAdminScreen(
    comments: List<Comment>,
    onDeleteComment: (Comment) -> Unit,
    onAddComment: (String, String) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        AddCommentForm(onSubmit = onAddComment)
        Spacer(modifier = Modifier.height(16.dp))
        comments.forEach { comment ->
            CommentItemView(comment = comment, onDelete = { onDeleteComment(comment) })
        }
    }
}
