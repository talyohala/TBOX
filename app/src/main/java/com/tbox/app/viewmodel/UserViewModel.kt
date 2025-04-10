package com.tbox.app.viewmodel

import androidx.lifecycle.ViewModel
import com.tbox.app.model.User
import com.tbox.app.repository.UserRepository

class UserViewModel : ViewModel() {
    private val repo = UserRepository()
    var currentUser: User? = null
        private set

    fun login(username: String, password: String): Boolean {
        val user = repo.login(username, password)
        currentUser = user
        return user != null
    }

    fun register(username: String, password: String): Boolean {
        val user = User(id = (0..99999).random(), username = username, password = password)
        return repo.register(user)
    }

    fun logout() {
        currentUser = null
    }
}
