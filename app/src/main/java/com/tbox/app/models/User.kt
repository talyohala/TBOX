package com.tbox.app.models

data class User(
    val id: String,
    val name: String,
    val email: String,
    val isBlocked: Boolean = false,
    val isPremium: Boolean = false
)
