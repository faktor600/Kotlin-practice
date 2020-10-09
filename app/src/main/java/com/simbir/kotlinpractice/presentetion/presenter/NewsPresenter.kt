package com.simbir.kotlinpractice.presentetion.presenter

import com.simbir.kotlinpractice.domain.Event
import com.simbir.kotlinpractice.domain.iteractors.GetCategoriesCase
import com.simbir.kotlinpractice.domain.iteractors.GetEventsCase
import com.simbir.kotlinpractice.presentetion.view.newsfragment.NewsView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class NewsPresenter(

    val getEventsCase: GetEventsCase,
    val getCategoriesCase: GetCategoriesCase

) : MvpPresenter<NewsView>() {

    private lateinit var disposableEvent: Disposable
    private lateinit var disposableCategory: Disposable

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        disposableEvent = getEventsCase.getEvents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ events ->
                viewState.hideProgress()
                viewState.setData(ArrayList(events))
            }

        disposableCategory = getCategoriesCase.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ categories ->
                viewState.setCategories(ArrayList(categories))
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposableCategory.dispose()
        disposableEvent.dispose()
    }

    fun updateNewsItems(events: List<Event>, requiredCategories: ArrayList<String>): List<Event>? {
        val newList: MutableList<Event> = ArrayList()
        for (item in events) {
            val categories: List<String> = item.eventCategories
            for (categoryRequired in requiredCategories) {
                var isCategoryRequired = false
                for (category in categories) {
                    if (category == categoryRequired) {
                        isCategoryRequired = true
                        break
                    }
                }
                if (isCategoryRequired) {
                    newList.add(item)
                    break
                }
            }
        }
        return newList
    }
}