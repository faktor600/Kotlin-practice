package com.simbir.kotlinpractice.data.json

import com.google.gson.annotations.SerializedName

class CategoryJson(

    @SerializedName("id")
    val id: Long,

    @SerializedName("name")
    val categoryName: String,

    @SerializedName("drawableId")
    val drawableRes: String
)