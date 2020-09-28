package com.simbir.kotlinpractice.data.json.model

import com.google.gson.annotations.SerializedName

class CategoryJson(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val categoryName: String,

    @SerializedName("drawableId")
    val drawableRes: Int
)