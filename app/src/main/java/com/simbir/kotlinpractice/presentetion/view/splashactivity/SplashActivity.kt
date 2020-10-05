package com.simbir.kotlinpractice.presentetion.view.splashactivity

import android.content.Context
import android.content.Intent
import android.view.View.NO_ID
import com.simbir.kotlinpractice.R
import com.simbir.kotlinpractice.presentetion.presenter.SplashActivityPresenter
import com.simbir.kotlinpractice.presentetion.view.BaseActivity
import com.simbir.kotlinpractice.presentetion.view.authentication.AuthenticationActivity
import com.simbir.kotlinpractice.presentetion.view.mainactivity.MainActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class SplashActivity : BaseActivity(), SplashActivityView  {

    @InjectPresenter
    lateinit var splashActivityPresenter: SplashActivityPresenter

    @ProvidePresenter
    fun providePresenter(): SplashActivityPresenter{
        return SplashActivityPresenter(getPreferences(Context.MODE_PRIVATE))
    }

    override fun getActivityLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun getActionBarId(): Int {
        return NO_ID
    }

    override fun initViews() {}

    override fun startActivity() {
        startActivity(Intent(this, AuthenticationActivity::class.java))
        finish()
    }
}