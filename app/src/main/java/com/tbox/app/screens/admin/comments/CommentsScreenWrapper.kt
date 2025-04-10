package com.tbox.app.screens.admin.comments

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tbox.app.viewmodels.CommentsViewModel

@Composable
fun CommentsScreenWrapper() {
    val viewModel: CommentsViewModel = viewModel()
    val comments = viewModel.comments.collectAsState().value

    CommentsAdminScreen(
        comments = comments,
        onDeleteComment = { viewModel.deleteComment(it) },
        onAddComment = { user, text -> viewModel.addComment(user, text) }
    )
}
