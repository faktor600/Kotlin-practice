package com.simbir.kotlinpractice.data.json.map

import com.simbir.kotlinpractice.data.json.EventJson
import com.simbir.kotlinpractice.domain.Event

class JsonEventMap : (EventJson) -> Event {

    override fun invoke(event: EventJson) = Event(
        id = event.id,
        eventName = event.eventName,
        eventCategories = event.eventCategories,
        date = event.date,
        organizationName = event.organizationName,
        location = event.location,
        phoneNumbers = event.phoneNumbers,
        eMail =  event.eMail,
        description = event.description,
        imageUrls = event.imageUrls,
        site = event.site
    )
}