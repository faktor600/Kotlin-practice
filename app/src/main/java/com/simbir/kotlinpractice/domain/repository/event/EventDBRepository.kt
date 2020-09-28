package com.simbir.kotlinpractice.domain.repository.event

import com.simbir.kotlinpractice.domain.Event
import io.reactivex.rxjava3.core.Single

interface EventDBRepository {

    fun getEventListFromDatabase(): Single<List<Event>>
}