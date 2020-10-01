package com.simbir.kotlinpractice.presentetion.view.splashactivity

import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

interface SplashActivityView : MvpView {

    @Skip
    fun startActivity()
}