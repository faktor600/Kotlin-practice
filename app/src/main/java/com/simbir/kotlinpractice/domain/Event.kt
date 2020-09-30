package com.simbir.kotlinpractice.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(
    val id: Long,
    val eventName: String,
    val eventCategories: List<String>,
    val date: String,
    val organizationName: String,
    val location: String,
    val phoneNumbers: List<String>,
    val eMail: String,
    val description: String,
    val imagesUrl: List<String>,
    val site: String
) : Parcelable {

    override fun equals(other: Any?): Boolean {
        return when (other) {
            this -> true
            !is Event -> false
            else -> {
                val compareEvent: Event = other

                compareEvent.id == id
                        && compareEvent.eventName == eventName
                        && compareEvent.date == date
                        && compareEvent.description ==description
                        && compareEvent.eMail == eMail
                        && compareEvent.eventCategories == eventCategories
                        && compareEvent.imagesUrl == imagesUrl
                        && compareEvent.location == location
                        && compareEvent.site == site
                        && compareEvent.phoneNumbers == phoneNumbers
                        && compareEvent.organizationName == organizationName
            }
        }
    }
}