package com.simbir.kotlinpractice.data.repositoryimpl.event

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.simbir.kotlinpractice.data.json.EventJson
import com.simbir.kotlinpractice.data.json.InitJson
import com.simbir.kotlinpractice.data.json.map.JsonEventMap
import com.simbir.kotlinpractice.domain.Event
import com.simbir.kotlinpractice.domain.repository.event.EventJsonRepository
import io.reactivex.rxjava3.core.Single
import java.io.InputStream
import javax.inject.Inject

class EventJsonRepositoryImpl @Inject constructor(

    private val inputStream: InputStream,
    private val gson: Gson,
    private val mapper: JsonEventMap,
    private val initJson: InitJson

): EventJsonRepository {

    override fun getEventListFromJson(): Single<List<Event>> {
        return Single.just(gson.fromJson(
            initJson.invoke(inputStream).orEmpty(),
            TypeToken.getParameterized(ArrayList::class.java, EventJson::class.java).type
            )as ArrayList<EventJson>)
            .flattenAsFlowable { events -> events }
            .map(mapper)
            .toList()

    }
}