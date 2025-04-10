package com.tbox.app.repository

class AuthRepository {
    private val users = mutableMapOf<String, String>()

    fun authenticate(email: String, password: String): Boolean {
        return users[email] == password
    }

    fun register(email: String, password: String) {
        users[email] = password
    }
}
