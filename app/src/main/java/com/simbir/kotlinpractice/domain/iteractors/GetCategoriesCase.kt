package com.simbir.kotlinpractice.domain.iteractors

import com.simbir.kotlinpractice.data.repositoryimpl.CategoryRepositoryImpl
import com.simbir.kotlinpractice.domain.Category
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetCategoriesCase

@Inject
constructor(private val categoryRepository: CategoryRepositoryImpl) {

    fun getCategories(): Single<List<Category>>{
        return categoryRepository.getCategoryList()
    }
}