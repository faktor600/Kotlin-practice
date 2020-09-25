package com.simbir.kotlinpractice.data.net

import com.simbir.kotlinpractice.data.net.model.CategoryNet
import com.simbir.kotlinpractice.data.net.model.EventNet
import io.reactivex.rxjava3.core.Single

class ApiConnectionImpl(private val retrofitApi: HelpApi): ApiConnection {


    override fun getEventById(id: Int): Single<EventNet> {
        return retrofitApi.getEventById(id)
    }

    override fun getEventList(): Single<List<EventNet>> {
        return retrofitApi.getEvents()
    }

    override fun getCategoryList(): Single<List<CategoryNet>> {
        return retrofitApi.getCategoriesEnglishName()
            .flattenAsFlowable { categories -> categories }
            .flatMapSingle { name -> retrofitApi.getCategory(name) }
            .toList()
    }
}