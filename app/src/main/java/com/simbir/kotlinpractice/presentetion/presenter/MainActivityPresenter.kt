package com.simbir.kotlinpractice.presentetion.presenter

import com.simbir.kotlinpractice.presentetion.view.mainactivity.MainAcitvityView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainActivityPresenter: MvpPresenter<MainAcitvityView>()