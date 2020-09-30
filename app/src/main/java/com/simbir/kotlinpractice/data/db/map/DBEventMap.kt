package com.simbir.kotlinpractice.data.db.map

import com.simbir.kotlinpractice.data.db.entity.EventDBEntity
import com.simbir.kotlinpractice.domain.Event
import javax.inject.Inject

class DBEventMap @Inject constructor(): (EventDBEntity) -> Event {

    override fun invoke(event: EventDBEntity) = Event(
        id = event.id,
        eventName = event.eventName,
        eventCategories = event.eventCategories,
        date = event.date,
        organizationName = event.orgName,
        location = event.location,
        phoneNumbers = event.phoneNumbers,
        eMail = event.eMail,
        description =  event.description,
        imageUrls = event.images,
        site = event.site
    )
}