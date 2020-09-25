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
    val eventName: Int,
    val eventCategories: List<String>,
    val date: String,
    val orgName: String,
    val location: String,
    val phoneNumbers: List<String>,
    val eMail: String,
    val description: String,
    val images: List<String>,
    val site: String)