package com.simbir.kotlinpractice.data.db.map

import com.simbir.kotlinpractice.data.db.entity.CategoryDBEntitiy
import com.simbir.kotlinpractice.domain.Category

class DBCategoryMap {

    fun getCategoryFromDatabase(category: CategoryDBEntitiy): Category{
        return Category(category.id.toInt(), category.name, category.imageRes.toString())
    }
}