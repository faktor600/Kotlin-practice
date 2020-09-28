package com.simbir.kotlinpractice.data.repositoryimpl.category

import com.google.gson.Gson
import com.simbir.kotlinpractice.data.json.map.JsonCategoryMap
import com.simbir.kotlinpractice.domain.Category
import com.simbir.kotlinpractice.domain.repository.category.CategoryJsonRepository
import io.reactivex.rxjava3.core.Single
import java.io.InputStream

class CategoryJsonRepositoryImpl(
    private val inputStream: InputStream?,
    private val gson: Gson,
    private val mapper: JsonCategoryMap
): CategoryJsonRepository {

    override fun getCategoryListFromJson(): Single<List<Category>> {
        return Single.just(gson.fromJson(initJson().orEmpty(), List::class.java))
            .flattenAsFlowable { categoryList -> categoryList }
            .map { category -> mapper.getCategoryFromJson(category) }
            .toList()

    }

    private fun initJson(): String?{
        return inputStream?.bufferedReader().use { it?.readLine() }
    }
}