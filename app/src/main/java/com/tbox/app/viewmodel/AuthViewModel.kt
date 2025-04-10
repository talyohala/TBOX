package com.tbox.app.viewmodel

import androidx.lifecycle.ViewModel
import com.tbox.app.repository.AuthRepository

class AuthViewModel : ViewModel() {
    private val authRepository = AuthRepository()

    fun login(email: String, password: String, onSuccess: () -> Unit) {
        if (authRepository.authenticate(email, password)) {
            onSuccess()
        }
    }

    fun register(email: String, password: String, onSuccess: () -> Unit) {
        authRepository.register(email, password)
        onSuccess()
    }
}
