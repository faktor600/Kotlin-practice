package com.simbir.kotlinpractice.presentetion.presenter

import com.simbir.kotlinpractice.domain.Event
import com.simbir.kotlinpractice.presentetion.view.eventdetails.EventDetailsView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class EventDetailsPresenter(val event: Event) : MvpPresenter<EventDetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setContent(event, event.date)
    }

    fun setPhoneNumbers(phoneNumbers: ArrayList<String>): String{
        return phoneNumbers.toString()
    }
}