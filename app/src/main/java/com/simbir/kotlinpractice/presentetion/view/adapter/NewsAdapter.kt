package com.simbir.kotlinpractice.presentetion.view.adapter

import com.simbir.kotlinpractice.R
import com.simbir.kotlinpractice.domain.Event
import com.simbir.kotlinpractice.presentetion.view.BaseAdapter
import com.simbir.kotlinpractice.presentetion.view.viewholder.ViewHolderNews

class NewsAdapter : BaseAdapter<Event, ViewHolderNews>() {

    override fun getLayoutId(): Int {
        return R.layout.item_news
    }
}