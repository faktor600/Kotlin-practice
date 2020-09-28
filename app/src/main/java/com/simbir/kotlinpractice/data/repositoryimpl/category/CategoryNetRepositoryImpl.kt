package com.simbir.kotlinpractice.data.repositoryimpl.category

import com.simbir.kotlinpractice.data.net.HelpApi
import com.simbir.kotlinpractice.data.net.map.NetCategoryMap
import com.simbir.kotlinpractice.domain.Category
import com.simbir.kotlinpractice.domain.repository.category.CategoryNetRepository
import io.reactivex.rxjava3.core.Single

class CategoryNetRepositoryImpl(
    private val api: HelpApi,
    private val mapper: NetCategoryMap
): CategoryNetRepository {

    override fun getCategoryListFromNet(): Single<List<Category>> {
        return api.getCategoriesEnglishName()
            .flattenAsFlowable { englishName -> englishName }
            .flatMapSingle { name -> api.getCategory(name) }
            .map { category -> mapper.getCategoryFromNet(category) }
            .toList()
    }
}