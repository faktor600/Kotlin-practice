package com.simbir.kotlinpractice.domain

import android.os.Parcel
import android.os.Parcelable

data class Event(
    val id: Int,
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

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readString()
    )

    companion object CREATOR : Parcelable.Creator<Event> {
        override fun createFromParcel(parcel: Parcel): Event {
            return Event(parcel)
        }

        override fun newArray(size: Int): Array<Event?> {
            return arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel?, p1: Int) {
        parcel?.writeInt(id)
        parcel?.writeString(eventName)
        parcel?.writeStringList(eventCategories)
        parcel?.writeString(date)
        parcel?.writeString(organizationName)
        parcel?.writeString(location)
        parcel?.writeStringList(phoneNumbers)
        parcel?.writeString(eMail)
        parcel?.writeString(description)
        parcel?.writeStringList(imagesUrl)
        parcel?.writeString(site)
    }

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