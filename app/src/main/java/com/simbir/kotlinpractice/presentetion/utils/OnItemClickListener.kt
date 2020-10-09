package com.simbir.kotlinpractice.presentetion.utils

interface OnItemClickListener<T>: (T) -> Unit{

    override fun invoke(p1: T)
}