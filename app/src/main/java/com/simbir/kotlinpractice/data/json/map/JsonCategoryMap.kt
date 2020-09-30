package com.simbir.kotlinpractice.data.json.map

import com.simbir.kotlinpractice.data.json.CategoryJson
import com.simbir.kotlinpractice.domain.Category

class JsonCategoryMap : (CategoryJson) -> Category {

    override fun invoke(category: CategoryJson) = Category(
        id = category.id,
        drawable = category.drawableRes,
        name = category.categoryName
    )
}