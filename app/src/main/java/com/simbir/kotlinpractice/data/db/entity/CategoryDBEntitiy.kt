package com.simbir.kotlinpractice.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryDBEntitiy(
    @PrimaryKey
    val id: Long,
    val name: String,
    val imageRes: Int
)