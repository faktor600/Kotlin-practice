package com.simbir.kotlinpractice.data.net.model

import com.google.gson.annotations.SerializedName

data class EventNet(

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val evenName: String,

    @SerializedName("startDate")
    val startDate: Long,

    @SerializedName("endDate")
    val endDate: Long,

    @SerializedName("description")
    val description: String,

    @SerializedName("status")
    val status: Long,

    @SerializedName("photos")
    val photos: List<String>,

    @SerializedName("category")
    val categories: List<String>,

    @SerializedName("createAt")
    val createAt: Long,

    @SerializedName("phone")
    val phone: String,

    @SerializedName("address")
    val location: String,

    @SerializedName("organisation")
    val organization: String,

    @SerializedName("eMail")
    val eMail: String,

    @SerializedName("site")
    val site: String
)