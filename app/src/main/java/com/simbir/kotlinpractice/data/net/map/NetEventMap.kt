package com.simbir.kotlinpractice.data.net.map

import com.simbir.kotlinpractice.data.net.model.EventNet
import com.simbir.kotlinpractice.domain.Event
import javax.inject.Inject

class NetEventMap @Inject constructor(): (EventNet) -> Event {

    override fun invoke(event: EventNet) = Event(
        id = event.id.toLong(),
        eventName = event.evenName,
        eventCategories = event.categories,
        date = "${event.startDate} - ${event.endDate}",
        organizationName = event.organization,
        location = event.location,
        phoneNumbers = listOf(event.phone),
        eMail = event.eMail,
        description = event.description,
        imageUrls = event.photos,
        site = event.site
    )
}