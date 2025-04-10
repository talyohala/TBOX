package com.tbox.app.model

data class AuthState(
    val isLoggedIn: Boolean = false,
    val userEmail: String = ""
)
