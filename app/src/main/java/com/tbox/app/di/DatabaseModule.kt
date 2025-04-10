package com.tbox.app.di

import android.content.Context
import androidx.room.Room
import com.tbox.app.data.AppDatabase
import com.tbox.app.data.dao.CommentDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "tbox_database"
        ).build()
    }

    @Provides
    fun provideCommentDao(db: AppDatabase): CommentDao {
        return db.commentDao()
    }
}
