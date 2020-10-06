package com.simbir.kotlinpractice.domain

data class Category(
    val id: Long,
    val drawable: Int,
    val name: String
) : DiffListItemModel {

    override fun isSameAs(other: DiffListItemModel): Boolean {
        return this == other
    }
}