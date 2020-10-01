package com.simbir.kotlinpractice.presentetion.utils

import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView

class ViewPagerListener(private val bottomNavigation: BottomNavigationView) : ViewPager.OnPageChangeListener {

    private val PROFILE_PAGE_NUMBER = 4
    private val PROFILE_POSITION = 3

    override fun onPageSelected(position: Int) {
        if(position == PROFILE_PAGE_NUMBER){
            bottomNavigation.menu.getItem(PROFILE_POSITION).isChecked = true
        }else{
            bottomNavigation.menu.getItem(position).isChecked = true
        }
    }

    override fun onPageScrollStateChanged(state: Int) {}

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
}