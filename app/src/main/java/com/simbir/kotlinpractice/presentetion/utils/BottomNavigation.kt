package com.simbir.kotlinpractice.presentetion.utils

import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigation(private val viewPager: ViewPager) {

    private val HELP_PAGE_NUMBER = 2
    private val PROFILE_PAGE_NUMBER = 4
    private val SEARCH_PAGE_NUMBER = 1
    private val NEWS_PAGE_NUMBER = 0

    private val HELP = "Помочь"
    private val PROFILE = "Профиль"
    private val SEARCH = "Поиск"
    private val NEWS = "Новости"

    val onNavigationView: BottomNavigationView.OnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener {
                item -> when(item.toString()){
            HELP -> viewPager.currentItem = HELP_PAGE_NUMBER
            PROFILE -> viewPager.currentItem = PROFILE_PAGE_NUMBER
            NEWS -> viewPager.currentItem = NEWS_PAGE_NUMBER
            SEARCH -> viewPager.currentItem = SEARCH_PAGE_NUMBER
        }
            return@OnNavigationItemSelectedListener false
    }
}