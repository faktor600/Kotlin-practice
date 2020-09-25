package com.simbir.kotlinpractice.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.simbir.kotlinpractice.data.db.dao.CategoryDao
import com.simbir.kotlinpractice.data.db.dao.EventDao
import com.simbir.kotlinpractice.data.db.entity.CategoryDBEntitiy
import com.simbir.kotlinpractice.data.db.entity.EventDBEntity

@Database(entities = [EventDBEntity::class, CategoryDBEntitiy::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
    abstract fun eventDao(): EventDao

    companion object{

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return (if(INSTANCE != null){
                INSTANCE
            }else{
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            })!!
        }
    }
}