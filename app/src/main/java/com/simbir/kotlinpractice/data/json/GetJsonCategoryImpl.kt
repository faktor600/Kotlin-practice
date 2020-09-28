package com.simbir.kotlinpractice.data.json

import com.google.gson.Gson
import com.simbir.kotlinpractice.data.json.model.CategoryJson
import io.reactivex.rxjava3.core.Single
import java.io.InputStream

class GetJsonCategoryImpl(private val inputStream: InputStream?, private val gson: Gson): GetJsonCase {

    override fun getJsonList(): Single<Any> {
        return Single.just(gson.fromJson(initJson(inputStream).orEmpty(), CategoryJson::class.java))
    }
}