package com.simbir.kotlinpractice.presentetion.view.eventdetails

import com.simbir.kotlinpractice.domain.Event
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface EventDetailsView : MvpView {

    @AddToEndSingle
    fun setContent(event: Event, date: String)
}