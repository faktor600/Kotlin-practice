package com.simbir.kotlinpractice.domain.iteractors

import com.simbir.kotlinpractice.data.repositoryimpl.EventRepositoryImpl
import com.simbir.kotlinpractice.domain.Event
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetEventsCase @Inject constructor(private val eventRepository: EventRepositoryImpl) {

    fun getEvents(): Single<List<Event>>{
        return eventRepository.getEventListFromNet()
    }
}