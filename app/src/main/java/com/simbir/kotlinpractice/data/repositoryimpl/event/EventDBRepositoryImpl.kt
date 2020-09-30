package com.simbir.kotlinpractice.data.repositoryimpl.event

import com.simbir.kotlinpractice.data.db.dao.EventDao
import com.simbir.kotlinpractice.data.db.map.DBEventMap
import com.simbir.kotlinpractice.domain.Event
import com.simbir.kotlinpractice.domain.repository.event.EventDBRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class EventDBRepositoryImpl @Inject constructor(

    private val eventDao: EventDao,
    private val mapper: DBEventMap

): EventDBRepository {

    override fun getEventListFromDatabase(): Single<List<Event>> {
        return eventDao.getAll()
            .flattenAsFlowable { events -> events }
            .map(mapper)
            .toList()
    }
}