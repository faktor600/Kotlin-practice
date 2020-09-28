package com.simbir.kotlinpractice.data.db

import androidx.room.TypeConverter

import java.util.Arrays
import java.util.stream.Collectors

class StringConverter {

    @TypeConverter
    fun fromListToString(items: List<String>): String{
        return items.joinToString()
    }
}