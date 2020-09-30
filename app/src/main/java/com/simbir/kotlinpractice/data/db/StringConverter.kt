package com.simbir.kotlinpractice.data.db

import androidx.room.TypeConverter

class StringConverter {

    @TypeConverter
    fun fromListToString(items: List<String>): String{
        return items.joinToString()
    }

    @TypeConverter
    fun fromStringToList(item: String): List<String>{
        return item.split(",")
    }
}