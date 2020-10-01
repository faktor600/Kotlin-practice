package com.simbir.kotlinpractice.presentetion.presenter

import android.content.SharedPreferences
import com.simbir.kotlinpractice.presentetion.view.splashactivity.SplashActivityView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import java.util.concurrent.TimeUnit

@InjectViewState
class SplashActivityPresenter(private val sharedPreferences: SharedPreferences) : MvpPresenter<SplashActivityView>() {

    private val LONG_DURATION: Long = 3000
    private val STANDARD_DURATION: Long = 1000

    private lateinit var disposable: Disposable

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        val splashDuration: Long = getSplashDuration()

        disposable = Completable.complete()
            .subscribeOn(Schedulers.io())
            .delay(splashDuration, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
            .subscribe{
                viewState.startActivity()
            }

    }

    private fun getSplashDuration(): Long{
        val prefKeyFirstLaunch = "pref_first_launch"

        return if(sharedPreferences.getBoolean(prefKeyFirstLaunch, true)){
            sharedPreferences.edit().putBoolean(prefKeyFirstLaunch, false).apply()
            LONG_DURATION
        }else{
            STANDARD_DURATION
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}
