package com.tbox.app.model

data class Comment(
    val id: String,
    val movieId: String,
    val userId: String,
    val username: String,
    val content: String,
    val timestamp: Long
)
