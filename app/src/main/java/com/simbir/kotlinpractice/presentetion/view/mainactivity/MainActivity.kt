package com.simbir.kotlinpractice.presentetion.view.mainactivity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View.NO_ID
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.simbir.kotlinpractice.R
import com.simbir.kotlinpractice.presentetion.presenter.MainActivityPresenter
import com.simbir.kotlinpractice.presentetion.utils.BottomNavigation
import com.simbir.kotlinpractice.presentetion.utils.ViewPagerListener
import com.simbir.kotlinpractice.presentetion.view.BaseActivity
import moxy.presenter.InjectPresenter

class MainActivity : BaseActivity(), MainAcitvityView {

    private val HELP_PAGE = 2

    @InjectPresenter
    lateinit var mainActivityPresenter: MainActivityPresenter

    private lateinit var viewPager: ViewPager
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun getActivityLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getActionBarId(): Int {
        return NO_ID
    }

    override fun initViews() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        viewPager = findViewById(R.id.mainActivityViewPager)

        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigation(viewPager).onNavigationView)

        viewPager.setOnPageChangeListener(ViewPagerListener(bottomNavigationView))
        viewPager.adapter = MainActivityPagerAdapter(supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        viewPager.currentItem = HELP_PAGE
    }
}
