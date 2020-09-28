package com.simbir.kotlinpractice.data.repositoryimpl.event

import com.google.gson.Gson
import com.simbir.kotlinpractice.data.json.map.JsonEventMap
import com.simbir.kotlinpractice.domain.Event
import com.simbir.kotlinpractice.domain.repository.event.EventJsonRepository
import io.reactivex.rxjava3.core.Single
import java.io.InputStream

class EventJsonRepositoryImpl(
    private val inputStream: InputStream,
    private val gson: Gson,
    private val mapper: JsonEventMap
): EventJsonRepository {

    override fun getEventListFromJson(): Single<List<Event>> {
        return Single.just(gson.fromJson(initJson().orEmpty(), List::class.java))
            .flattenAsFlowable { events -> events }
            .map { event -> mapper.getEventFromJson(event) }
            .toList()

    }

    private fun initJson(): String?{
        return inputStream?.bufferedReader().use { it?.readLine() }
    }
}