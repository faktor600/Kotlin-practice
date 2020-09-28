package com.simbir.kotlinpractice.data.db.dao

import androidx.room.*
import com.simbir.kotlinpractice.data.db.entity.EventDBEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

@Dao
interface EventDao {

    @Query("SELECT * FROM eventdbentity")
    fun getAll(): Maybe<List<EventDBEntity>>

    @Query("SELECT * FROM eventdbentity WHERE id = :id")
    fun getEventById(id: Int): Maybe<EventDBEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg event: EventDBEntity): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(events: List<EventDBEntity>): Completable

    @Delete
    fun delete(event: EventDBEntity): Completable
}