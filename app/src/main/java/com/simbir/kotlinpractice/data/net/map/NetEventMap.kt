package com.simbir.kotlinpractice.data.net.map

import com.simbir.kotlinpractice.data.net.model.EventNet
import com.simbir.kotlinpractice.domain.Event

class NetEventMap {

    fun getEventFromNet(event: EventNet): Event{
        return Event(event.id.toInt(), event.evenName, event.categories,
            "$event.startDate - $event.endDate", event.organization, event.location,
            listOf(event.phone), event.eMail, event.description, event.photos, event.site)
    }
}