package com.simbir.kotlinpractice.presentetion.view.help

import com.simbir.kotlinpractice.domain.Category
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface HelpView : MvpView {

    fun hideProgress()

    fun setData(items: List<Category>)
}