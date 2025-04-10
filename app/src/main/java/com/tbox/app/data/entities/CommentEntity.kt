package com.tbox.app.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comments")
data class CommentEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val movieId: String,
    val userName: String,
    val text: String
)
