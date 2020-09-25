package com.simbir.kotlinpractice.data.net

import com.simbir.kotlinpractice.data.net.model.CategorNet
import com.simbir.kotlinpractice.data.net.model.EventNet
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface HelpApi {

    @GET("categories")
    fun getCategoriesEnglishName(): Single<List<String>>

    @GET("categories")
    fun getCategory(nameInEnglish: String): Single<CategorNet>

    @GET("events")
    fun getEventById(id: Int): Single<EventNet>

    @GET("events")
    fun getEvents(): Single<List<EventNet>>
}