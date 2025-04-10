package com.tbox.app.database.daos

import androidx.room.*
import com.tbox.app.database.entities.CommentEntity

@Dao
interface CommentDao {

    @Query("SELECT * FROM comments")
    suspend fun getAll(): List<CommentEntity>

    @Query("SELECT * FROM comments WHERE movieId = :movieId")
    suspend fun getByMovieId(movieId: String): List<CommentEntity>

    @Delete
    suspend fun delete(comment: CommentEntity)
}
