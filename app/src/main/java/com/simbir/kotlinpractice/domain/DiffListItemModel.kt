package com.simbir.kotlinpractice.domain

interface DiffListItemModel {

    fun isSameAs(other: DiffListItemModel): Boolean
}