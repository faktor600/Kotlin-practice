package com.simbir.kotlinpractice.data.json

import com.google.gson.Gson
import io.reactivex.rxjava3.core.Single
import java.io.InputStream
import java.lang.reflect.Type

class GetJsonCaseImpl(private val inputStream: InputStream?, private val gson: Gson): GetJsonCase {

    override fun getJsonList(type: Type): Single<Any> {
        return Single.just(gson.fromJson(initJson().orEmpty(), type))
    }

    private fun initJson(): String?{
        return inputStream?.bufferedReader().use { it?.readLine() }
    }
}