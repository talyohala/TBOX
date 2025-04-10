package com.tbox.app.models

data class Comment(
    val id: Int,
    val userName: String,
    val text: String,
    val timestamp: Long = System.currentTimeMillis()
)
