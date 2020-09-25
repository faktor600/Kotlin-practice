package com.simbir.kotlinpractice.data.json

import io.reactivex.rxjava3.core.Single

interface GetJsonCase {

    fun getJsonList(requiredClass: Class<Any>): Single<Any>
}