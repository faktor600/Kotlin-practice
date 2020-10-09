package com.simbir.kotlinpractice.data.net.map

import com.simbir.kotlinpractice.data.net.model.CategoryNet
import com.simbir.kotlinpractice.domain.Category
import javax.inject.Inject

class NetCategoryMap @Inject constructor(): (CategoryNet) -> Category {

    override fun invoke(category: CategoryNet) = Category(
        id = category.id.toLong(),
        drawable = category.image,
        name = category.name
    )
}