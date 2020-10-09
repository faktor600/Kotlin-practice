package com.simbir.kotlinpractice.data.repositoryimpl.category

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.simbir.kotlinpractice.data.json.CategoryJson
import com.simbir.kotlinpractice.data.json.InitJson
import com.simbir.kotlinpractice.data.json.map.JsonCategoryMap
import com.simbir.kotlinpractice.domain.Category
import com.simbir.kotlinpractice.domain.repository.category.CategoryJsonRepository
import io.reactivex.rxjava3.core.Single
import java.io.InputStream
import javax.inject.Inject

class CategoryJsonRepositoryImpl @Inject constructor(

    private val inputStream: InputStream?,
    private val gson: Gson,
    private val mapper: JsonCategoryMap,
    private val initJson: InitJson

): CategoryJsonRepository {

    override fun getCategoryListFromJson(): Single<List<Category>> {
        return Single.just(gson.fromJson(
            initJson.invoke(inputStream).orEmpty(),
            TypeToken.getParameterized(ArrayList::class.java, CategoryJson::class.java).type) as ArrayList<CategoryJson>
        )
            .flattenAsFlowable { categories -> categories }
            .map(mapper)
            .toList()
    }
}