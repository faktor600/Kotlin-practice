package com.simbir.kotlinpractice.presentetion.presenter

import com.simbir.kotlinpractice.presentetion.view.mainactivity.MainActivityView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainActivityPresenter: MvpPresenter<MainActivityView>()