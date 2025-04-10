package com.tbox.app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tbox.app.data.CommentRepository
import com.tbox.app.models.Comment
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CommentsViewModel : ViewModel() {
    val comments: StateFlow<List<Comment>> = CommentRepository.comments

    fun deleteComment(comment: Comment) {
        viewModelScope.launch {
            CommentRepository.deleteComment(comment)
        }
    }

    fun addComment(userName: String, text: String) {
        viewModelScope.launch {
            CommentRepository.addComment(userName, text)
        }
    }
}
