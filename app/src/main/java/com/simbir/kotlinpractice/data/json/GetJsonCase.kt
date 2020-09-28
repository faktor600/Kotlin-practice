package com.simbir.kotlinpractice.data.json

import io.reactivex.rxjava3.core.Single
import java.lang.reflect.Type

interface GetJsonCase {

    fun getJsonList(type: Type): Single<Any>
}