package com.simbir.kotlinpractice.domain.repository

import com.simbir.kotlinpractice.domain.Event
import io.reactivex.rxjava3.core.Single

interface EventRepository {

    fun getEventList(): Single<List<Event>>
}