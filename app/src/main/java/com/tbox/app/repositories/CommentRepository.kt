package com.tbox.app.repositories

import com.tbox.app.database.daos.CommentDao
import com.tbox.app.models.Comment
import com.tbox.app.models.toDomain
import com.tbox.app.models.toEntity
import javax.inject.Inject

class CommentRepository @Inject constructor(
    private val commentDao: CommentDao
) {
    suspend fun getCommentsForMovie(movieId: String): List<Comment> {
        return if (movieId == "all") {
            commentDao.getAll().map { it.toDomain() }
        } else {
            commentDao.getByMovieId(movieId).map { it.toDomain() }
        }
    }

    suspend fun deleteComment(comment: Comment) {
        commentDao.delete(comment.toEntity())
    }
}
