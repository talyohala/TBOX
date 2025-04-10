package com.tbox.app.viewmodels

import com.tbox.app.models.Comment

class CommentManager {
    private val comments = mutableListOf<Comment>()

    fun getComments(): List<Comment> = comments

    fun addComment(comment: Comment) {
        comments.add(comment.copy(id = comments.size + 1))
    }

    fun deleteComment(id: Int): Boolean {
        return comments.removeIf { it.id == id }
    }
}
