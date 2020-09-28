package com.simbir.kotlinpractice.data.json

import com.google.gson.annotations.SerializedName

class EventJson(

    @SerializedName("eventId")
    val id: Int,

    @SerializedName("eventName")
    val eventName: String,

    @SerializedName("categories")
    val eventCategories: List<String>,

    @SerializedName("date")
    val date: String,

    @SerializedName("organizationName")
    val organizationName: String,

    @SerializedName("location")
    val location: String,

    @SerializedName("phoneNumbers")
    val phoneNumbers: List<String>,

    @SerializedName("e-mail")
    val eMail: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("images")
    val imageUrls: List<String>,

    @SerializedName("site")
    val site: String
)