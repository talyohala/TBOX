package com.tboxe.repository

import com.tboxe.data.UserDao
import com.tboxe.model.User

class UserRepository(private val userDao: UserDao) {
    suspend fun getAdmins() = userDao.getAllAdmins()
    suspend fun getUser(id: Int) = userDao.getUserById(id)
    suspend fun insertUser(user: User) = userDao.insertUser(user)
    suspend fun deleteUser(user: User) = userDao.deleteUser(user)
}
