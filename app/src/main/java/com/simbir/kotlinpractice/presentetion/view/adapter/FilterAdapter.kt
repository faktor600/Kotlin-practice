package com.simbir.kotlinpractice.presentetion.view.adapter

import com.simbir.kotlinpractice.R
import com.simbir.kotlinpractice.domain.Category
import com.simbir.kotlinpractice.presentetion.view.BaseAdapter
import com.simbir.kotlinpractice.presentetion.view.viewholder.ViewHolderFilter

class FilterAdapter : BaseAdapter<Category, ViewHolderFilter>() {
    override fun getLayoutId(): Int {
        return R.layout.item_filter
    }
}