package com.tbox.app.database.daos

import androidx.room.*
import com.tbox.app.database.entities.TagEntity

@Dao
interface TagDao {

    @Query("SELECT * FROM tags")
    suspend fun getAll(): List<TagEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tag: TagEntity)

    @Delete
    suspend fun delete(tag: TagEntity)
}
