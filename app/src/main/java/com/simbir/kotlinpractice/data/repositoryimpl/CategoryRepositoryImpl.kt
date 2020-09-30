package com.simbir.kotlinpractice.data.repositoryimpl

import com.simbir.kotlinpractice.data.repositoryimpl.category.CategoryDBRepositoryImpl
import com.simbir.kotlinpractice.data.repositoryimpl.category.CategoryJsonRepositoryImpl
import com.simbir.kotlinpractice.data.repositoryimpl.category.CategoryNetRepositoryImpl
import com.simbir.kotlinpractice.domain.Category
import com.simbir.kotlinpractice.domain.repository.CategoryRepository
import io.reactivex.rxjava3.core.Single
import java.util.*
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(

    private val categoryDB: CategoryDBRepositoryImpl,
    private val categoryNet: CategoryNetRepositoryImpl,
    private val categoryJson: CategoryJsonRepositoryImpl

): CategoryRepository {

    override fun getCategoryList(): Single<List<Category>> {
        return Single.concat(
            categoryNet.getCategoryListFromNet(),
            categoryDB.getCategoryListFromDatabase(),
            categoryJson.getCategoryListFromJson()
        )
            .filter { categories -> categories.isEmpty()}
            .first(Collections.emptyList())
    }
}