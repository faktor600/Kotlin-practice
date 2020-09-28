package com.simbir.kotlinpractice.data.json

import io.reactivex.rxjava3.core.Single
import java.io.InputStream

interface GetJsonCase {

    fun getJsonList(): Single<Any>

    fun initJson(inputStream: InputStream?): String?{
        return inputStream?.bufferedReader().use { it?.readLine() }
    }
}