package com.tbox.app.viewmodels

import kotlinx.serialization.*
import kotlinx.serialization.json.Json

@Serializable
data class User(
    val id: Int,
    val name: String,
    val isAdmin: Boolean
)

class UserManager {

    private val users = mutableListOf<User>()

    fun addUser(user: User) {
        users.add(user)
    }

    fun removeUserById(id: Int) {
        users.removeIf { it.id == id }
    }

    fun isAdmin(userId: Int): Boolean {
        return users.find { it.id == userId }?.isAdmin ?: false
    }

    fun serializeUsers(): String {
        return Json.encodeToString(users)
    }

    fun deserializeUsers(json: String) {
        val decoded = Json.decodeFromString<List<User>>(json)
        users.clear()
        users.addAll(decoded)
    }
}
