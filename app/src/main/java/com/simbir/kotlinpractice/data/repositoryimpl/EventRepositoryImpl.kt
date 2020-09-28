package com.simbir.kotlinpractice.data.repositoryimpl

import com.simbir.kotlinpractice.data.repositoryimpl.event.EventDBRepositoryImpl
import com.simbir.kotlinpractice.data.repositoryimpl.event.EventJsonRepositoryImpl
import com.simbir.kotlinpractice.data.repositoryimpl.event.EventNetRepositoryImpl
import com.simbir.kotlinpractice.domain.Event
import com.simbir.kotlinpractice.domain.repository.event.EventNetRepository
import io.reactivex.rxjava3.core.Single
import java.util.*

class EventRepositoryImpl(
    private val eventJson: EventJsonRepositoryImpl,
    private val eventNet: EventNetRepositoryImpl,
    private val eventDB: EventDBRepositoryImpl
): EventNetRepository {

    override fun getEventListFromNet(): Single<List<Event>> {
        return Single.concat(
            eventNet.getEventListFromNet(),
            eventDB.getEventListFromDatabase(),
            eventJson.getEventListFromJson()
        )
            .filter { events -> events.isEmpty()}
            .first(Collections.emptyList())
    }
}