package com.tbox.app.viewmodels

import androidx.lifecycle.ViewModel
import com.tbox.app.models.User
import java.io.File
import kotlinx.serialization.*
import kotlinx.serialization.json.*

class UserManager : ViewModel() {
    private val usersFile = File("data/users.json")
    private var users = mutableListOf<User>()

    init {
        if (usersFile.exists()) {
            val text = usersFile.readText()
            users = Json.decodeFromString(text)
        }
    }

    fun getAllUsers(): List<User> = users

    fun addUser(user: User) {
        users.add(user)
        save()
    }

    fun deleteUser(id: String) {
        users.removeIf { it.id == id }
        save()
    }

    fun togglePremium(id: String) {
        users.find { it.id == id }?.let {
            it.isPremium = !it.isPremium
            save()
        }
    }

    fun toggleAdmin(id: String) {
        users.find { it.id == id }?.let {
            it.isAdmin = !it.isAdmin
            save()
        }
    }

    private fun save() {
        usersFile.writeText(Json.encodeToString(users))
    }
}
