package com.simbir.kotlinpractice.presentetion.view.newsfragment

import com.simbir.kotlinpractice.domain.Category
import com.simbir.kotlinpractice.domain.Event
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface NewsView : MvpView {

    fun hideProgress()

    fun setData(items: ArrayList<Event>)

    fun setCategories(items: ArrayList<Category>)
}