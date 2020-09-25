package com.simbir.kotlinpractice.data.net.model

import com.google.gson.annotations.SerializedName

data class CategorNet(

    @SerializedName("name")
    private val name: String,

    @SerializedName("nameEn")
    private val nameEn: String,

    @SerializedName("id")
    private val id: String,

    @SerializedName("image")
    private val image: String)