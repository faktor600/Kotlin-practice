package com.simbir.kotlinpractice.data.json.map

import com.simbir.kotlinpractice.data.json.CategoryJson
import com.simbir.kotlinpractice.domain.Category

class JsonCategoryMap {

    fun getCategoryFromJson(category: CategoryJson): Category{
        return Category(category.id, category.categoryName, category.drawableRes.toString())
    }
}