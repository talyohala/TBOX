package com.tbox.app.data.dao

import androidx.room.*
import com.tbox.app.data.entities.CommentEntity

@Dao
interface CommentDao {
    @Query("SELECT * FROM comments WHERE movieId = :movieId ORDER BY id DESC")
    suspend fun getCommentsForMovie(movieId: String): List<CommentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(comment: CommentEntity)

    @Delete
    suspend fun delete(comment: CommentEntity)
}
