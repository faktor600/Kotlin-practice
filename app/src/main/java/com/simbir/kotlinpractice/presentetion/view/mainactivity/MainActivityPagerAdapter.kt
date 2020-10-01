package com.simbir.kotlinpractice.presentetion.view.mainactivity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainActivityPagerAdapter(

    private val fragmentManager: FragmentManager,
    private val behavior: Int

) : FragmentPagerAdapter(fragmentManager, behavior) {

    private lateinit var fragments: List<Fragment>

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}