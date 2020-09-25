package com.simbir.kotlinpractice.data.net.model

import com.google.gson.annotations.SerializedName

data class CategoryNet(

    @SerializedName("name")
    val name: String,

    @SerializedName("nameEn")
    val nameEn: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("image")
    val image: String)