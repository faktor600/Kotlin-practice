package com.simbir.kotlinpractice.presentetion.presenter

import com.simbir.kotlinpractice.domain.iteractors.GetCategoriesCase
import com.simbir.kotlinpractice.presentetion.view.help.HelpView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import java.util.*
import kotlin.collections.ArrayList

class HelpPresenter(private val getCategoriesCase: GetCategoriesCase) : MvpPresenter<HelpView>() {

    private lateinit var disposable: Disposable

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        disposable = getCategoriesCase.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ categories ->
                viewState.hideProgress()
                viewState.setData(ArrayList(categories))
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}