package com.simbir.kotlinpractice.data.db.map

import com.simbir.kotlinpractice.data.db.entity.EventDBEntity
import com.simbir.kotlinpractice.domain.Event

class DBEventMap : (EventDBEntity) -> Event {

    override fun invoke(event: EventDBEntity) = Event(
        event.id,
        event.eventName,
        event.eventCategories,
        event.date,
        event.orgName,
        event.location,
        event.phoneNumbers,
        event.eMail,
        event.description,
        event.images,
        event.site
    )
}