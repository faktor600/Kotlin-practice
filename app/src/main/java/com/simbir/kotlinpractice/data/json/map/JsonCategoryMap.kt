package com.simbir.kotlinpractice.data.json.map

import com.simbir.kotlinpractice.data.json.CategoryJson
import com.simbir.kotlinpractice.domain.Category
import javax.inject.Inject

class JsonCategoryMap @Inject constructor(): (CategoryJson) -> Category {

    override fun invoke(category: CategoryJson) = Category(
        id = category.id,
        drawable = category.drawableRes,
        name = category.categoryName
    )
}