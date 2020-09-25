package com.simbir.kotlinpractice.data.net.map

import com.simbir.kotlinpractice.data.net.model.CategoryNet
import com.simbir.kotlinpractice.domain.Category

class NetCategoryMap {

    fun getCategoryFromNet(category: CategoryNet): Category{
        return Category(category.id.toInt(), category.name, category.image)
    }
}