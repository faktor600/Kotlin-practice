package com.simbir.kotlinpractice.data.json.map

import com.simbir.kotlinpractice.data.json.model.EventJson
import com.simbir.kotlinpractice.domain.Event

class JsonEventMap {

    fun getEventFromJson(event: EventJson): Event{
        return Event(event.id, event.eventName, event.eventCategories, event.date,
            event.organizationName, event.location, event.phoneNumbers, event.eMail,
            event.description, event.imageUrls, event.site)
    }
}