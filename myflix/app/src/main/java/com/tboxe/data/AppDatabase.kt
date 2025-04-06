package com.tboxe.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tboxe.model.Movie
import com.tboxe.model.User

@Database(entities = [User::class, Movie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun movieDao(): MovieDao
}
