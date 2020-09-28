package com.simbir.kotlinpractice.domain.repository.category

import com.simbir.kotlinpractice.domain.Category
import io.reactivex.rxjava3.core.Single

interface CategoryJsonRepository {

    fun getCategoryListFromJson(): Single<List<Category>>
}