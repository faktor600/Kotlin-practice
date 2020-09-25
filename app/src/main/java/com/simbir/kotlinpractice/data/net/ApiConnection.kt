package com.simbir.kotlinpractice.data.net

import com.simbir.kotlinpractice.data.net.model.CategoryNet
import com.simbir.kotlinpractice.data.net.model.EventNet
import io.reactivex.rxjava3.core.Single

interface ApiConnection {

    fun getEventList(): Single<List<EventNet>>

    fun getCategoryList(): Single<List<CategoryNet>>

    fun getEventById(id: Int): Single<EventNet>
}