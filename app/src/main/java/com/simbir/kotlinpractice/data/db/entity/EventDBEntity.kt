package com.simbir.kotlinpractice.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.simbir.kotlinpractice.data.db.StringConverter

@Entity
@TypeConverters(StringConverter::class)
data class EventDBEntity(
    @PrimaryKey
    val id: Long,
    val eventName: String,
    @TypeConverters(StringConverter::class)
    val eventCategories: List<String>,
    val date: String,
    val orgName: String,
    val location: String,
    @TypeConverters(StringConverter::class)
    val phoneNumbers: List<String>,
    val eMail: String,
    val description: String,
    @TypeConverters(StringConverter::class)
    val images: List<String>,
    val site: String
)