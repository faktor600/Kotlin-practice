package com.simbir.kotlinpractice.presentetion.presenter

import android.content.Intent
import android.graphics.Bitmap
import com.simbir.kotlinpractice.presentetion.view.profile.ProfileView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class ProfilePresenter : MvpPresenter<ProfileView>() {

    fun getPhotoProfile(data: Intent?): Bitmap{
        return data?.extras?.get("data") as Bitmap
    }
}