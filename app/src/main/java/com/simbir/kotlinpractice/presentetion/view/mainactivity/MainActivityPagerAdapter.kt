package com.simbir.kotlinpractice.presentetion.view.mainactivity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.simbir.kotlinpractice.presentetion.view.help.HelpFragment
import com.simbir.kotlinpractice.presentetion.view.profile.ProfileFragment

class MainActivityPagerAdapter(

    private val fragmentManager: FragmentManager,
    private val behavior: Int

) : FragmentPagerAdapter(fragmentManager, behavior) {

    private val fragments: ArrayList<Fragment> = ArrayList()

    init {
        fragments.add(HelpFragment())
        fragments.add(ProfileFragment())
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}