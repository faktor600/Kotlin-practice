package com.simbir.kotlinpractice.data.net.map

import com.simbir.kotlinpractice.data.net.model.CategoryNet
import com.simbir.kotlinpractice.domain.Category

class NetCategoryMap : (CategoryNet) -> Category {

    override fun invoke(category: CategoryNet) = Category(
        category.id.toLong(),
        category.image.toInt(),
        category.name
    )
}