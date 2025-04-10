package com.tbox.app.repository

import com.tbox.app.model.User

class UserRepository {
    private val users = mutableListOf<User>()

    fun register(user: User): Boolean {
        if (users.any { it.username == user.username }) return false
        users.add(user)
        return true
    }

    fun login(username: String, password: String): User? {
        return users.find { it.username == username && it.password == password }
    }

    fun getUserById(id: Int): User? = users.find { it.id == id }
}
