package com.simbir.kotlinpractice.di

import android.content.Context
import androidx.room.Room
import com.simbir.kotlinpractice.data.db.AppDatabase
import com.simbir.kotlinpractice.data.db.dao.CategoryDao
import dagger.Module
import dagger.Provides

@Module
class AppDatabaseModule(private val context: Context) {

    @AppDatabaseScope
    private val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "database"
    )
        .build()

    @Provides
    fun provideCategoryDao(): CategoryDao{
        return appDatabase.categoryDao()
    }
}