package com.simbir.kotlinpractice.presentetion.view

import android.os.Bundle
import android.view.View.NO_ID
import androidx.appcompat.app.ActionBar
import moxy.MvpAppCompatActivity

abstract class BaseActivity : MvpAppCompatActivity() {

    abstract fun getActivityLayoutId(): Int

    abstract fun getActionBarId(): Int

    abstract fun initViews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getActivityLayoutId())

        if(getActionBarId() != NO_ID){
            supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            supportActionBar?.customView = findViewById(getActionBarId())
        } else{
            supportActionBar?.hide()
        }
        initViews()
    }
}