package com.simbir.kotlinpractice.domain.repository

import com.simbir.kotlinpractice.domain.Category
import io.reactivex.rxjava3.core.Single

interface CategoryRepository {

    fun getCategoryList(): Single<List<Category>>
}