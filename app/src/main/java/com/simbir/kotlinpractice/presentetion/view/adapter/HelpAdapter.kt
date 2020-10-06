package com.simbir.kotlinpractice.presentetion.view.adapter

import com.simbir.kotlinpractice.R
import com.simbir.kotlinpractice.domain.Category
import com.simbir.kotlinpractice.presentetion.view.BaseAdapter
import com.simbir.kotlinpractice.presentetion.view.viewholder.ViewHolderHelp

class HelpAdapter : BaseAdapter<Category, ViewHolderHelp>() {

    override fun getLayoutId(): Int {
        return R.layout.items_help_list
    }
}