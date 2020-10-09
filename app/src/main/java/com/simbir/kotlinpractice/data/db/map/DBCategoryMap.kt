package com.simbir.kotlinpractice.data.db.map

import com.simbir.kotlinpractice.data.db.entity.CategoryDBEntitiy
import com.simbir.kotlinpractice.domain.Category
import javax.inject.Inject

class DBCategoryMap @Inject constructor(): (CategoryDBEntitiy) -> Category{

    override fun invoke(category: CategoryDBEntitiy) = Category(
        id = category.id,
        drawable = category.imageRes.toString(),
        name = category.name
    )
}