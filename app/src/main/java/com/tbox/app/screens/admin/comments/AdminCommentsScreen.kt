package com.tbox.app.screens.admin.comments

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tbox.app.screens.admin.comments.components.CommentItemView
import com.tbox.app.viewmodels.AdminCommentsViewModel

@Composable
fun AdminCommentsScreen(viewModel: AdminCommentsViewModel = hiltViewModel()) {
    val comments by viewModel.comments.collectAsState()
    var movieId by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("סינון תגובות לפי מזהה סרט", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = movieId,
            onValueChange = { movieId = it },
            label = { Text("Movie ID") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            viewModel.loadComments(movieId.ifEmpty { "all" })
        }) {
            Text("טען תגובות")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(comments) { comment ->
                CommentItemView(comment = comment) {
                    viewModel.deleteComment(comment)
                }
            }
        }
    }
}
