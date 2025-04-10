package com.tbox.app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tbox.app.data.dao.CommentDao
import com.tbox.app.data.entities.CommentEntity

@Database(entities = [CommentEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun commentDao(): CommentDao
}
