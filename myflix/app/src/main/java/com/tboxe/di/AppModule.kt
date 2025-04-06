package com.tboxe.di

import android.content.Context
import androidx.room.Room
import com.tboxe.data.AppDatabase
import com.tboxe.repository.MovieRepository
import com.tboxe.repository.UserRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "tboxe_database"
        ).fallbackToDestructiveMigration().build()
    }

    single { get<AppDatabase>().userDao() }
    single { get<AppDatabase>().movieDao() }

    single { UserRepository(get()) }
    single { MovieRepository(get()) }
}
