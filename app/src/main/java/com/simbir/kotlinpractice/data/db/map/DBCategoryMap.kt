package com.simbir.kotlinpractice.data.db.map

import com.simbir.kotlinpractice.data.db.entity.CategoryDBEntitiy
import com.simbir.kotlinpractice.domain.Category

class DBCategoryMap : (CategoryDBEntitiy) -> Category{

    override fun invoke(category: CategoryDBEntitiy) = Category(
        category.id,
        category.imageRes,
        category.name
    )
}