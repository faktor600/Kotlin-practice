package com.simbir.kotlinpractice.data.dao

import androidx.room.*
import com.simbir.kotlinpractice.data.db.CategoryDBEntitiy
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

@Dao
interface CategoryDao {

    @Query("SELECT * FROM categorydbentitiy")
    fun getAll(): Maybe<List<CategoryDBEntitiy>>

    @Query("SELECT * FROM categorydbentitiy WHERE id = :id")
    fun getCategoryById(id: Int): Maybe<CategoryDBEntitiy>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg category: CategoryDBEntitiy): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(categories: List<CategoryDBEntitiy>): Completable

    @Delete
    fun delete(category: CategoryDBEntitiy): Completable
}