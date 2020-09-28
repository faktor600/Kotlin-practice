package com.simbir.kotlinpractice.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

import com.simbir.kotlinpractice.data.db.dao.CategoryDao
import com.simbir.kotlinpractice.data.db.dao.EventDao
import com.simbir.kotlinpractice.data.db.entity.CategoryDBEntitiy
import com.simbir.kotlinpractice.data.db.entity.EventDBEntity

@Database(entities = [EventDBEntity::class, CategoryDBEntitiy::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
    abstract fun eventDao(): EventDao
}