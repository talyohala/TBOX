package com.tbox.app.repository

import com.tbox.app.data.dao.CommentDao
import com.tbox.app.data.entities.CommentEntity
import javax.inject.Inject

class CommentRepository @Inject constructor(
    private val dao: CommentDao
) {
    suspend fun getCommentsForMovie(movieId: String): List<CommentEntity> {
        return dao.getCommentsForMovie(movieId)
    }

    suspend fun addComment(comment: CommentEntity) {
        dao.insert(comment)
    }

    suspend fun deleteComment(comment: CommentEntity) {
        dao.delete(comment)
    }
}
