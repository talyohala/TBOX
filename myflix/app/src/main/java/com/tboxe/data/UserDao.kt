package com.tboxe.data

import androidx.room.*
import com.tboxe.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE isAdmin = 1")
    suspend fun getAllAdmins(): List<User>

    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getUserById(id: Int): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}
