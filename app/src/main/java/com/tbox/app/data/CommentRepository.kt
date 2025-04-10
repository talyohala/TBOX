package com.tbox.app.data

import com.tbox.app.models.Comment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.*

object CommentRepository {
    private val _comments = MutableStateFlow<List<Comment>>(listOf(
        Comment(UUID.randomUUID().toString(), "דני", "סרט מדהים!"),
        Comment(UUID.randomUUID().toString(), "נועה", "נהניתי מאוד מהצפייה.")
    ))
    val comments: StateFlow<List<Comment>> = _comments

    fun deleteComment(comment: Comment) {
        _comments.value = _comments.value.filterNot { it.id == comment.id }
    }

    fun addComment(userName: String, text: String) {
        val newComment = Comment(UUID.randomUUID().toString(), userName, text)
        _comments.value = _comments.value + newComment
    }
}
