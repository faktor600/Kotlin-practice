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
    val imageUrls: List<String>,
    val site: String
) : Parcelable