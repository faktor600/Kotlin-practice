package com.simbir.kotlinpractice.data.net.model

import com.google.gson.annotations.SerializedName

data class EventNet(

    @SerializedName("id")
    private val id: String,

    @SerializedName("name")
    private val evenName: String,

    @SerializedName("startDate")
    private val startDate: Long,

    @SerializedName("endDate")
    private val endDate: Long,

    @SerializedName("description")
    private val description: String,

    @SerializedName("status")
    private val status: Long,

    @SerializedName("photos")
    private val photos: List<String>,

    @SerializedName("category")
    private val categories: List<String>,

    @SerializedName("createAt")
    private val createAt: Long,

    @SerializedName("phone")
    private val phone: String,

    @SerializedName("address")
    private val location: String,

    @SerializedName("organisation")
    private val organization: String,

    @SerializedName("eMail")
    private val eMail: String,

    @SerializedName("site")
    private val site: String)