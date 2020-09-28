package com.simbir.kotlinpractice.data.repositoryimpl.event

import com.simbir.kotlinpractice.data.net.HelpApi
import com.simbir.kotlinpractice.data.net.map.NetEventMap
import com.simbir.kotlinpractice.domain.Event
import com.simbir.kotlinpractice.domain.repository.event.EventNetRepository
import io.reactivex.rxjava3.core.Single

class EventNetRepositoryImpl(
    private val api: HelpApi,
    private val mapper: NetEventMap
): EventNetRepository {

    override fun getEventListFromNet(): Single<List<Event>> {
        return api.getEvents()
            .flattenAsFlowable { events -> events }
            .map { event -> mapper.getEventFromNet(event) }
            .toList()
    }
}