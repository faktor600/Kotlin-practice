package com.simbir.kotlinpractice.presentetion.view.profile

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.provider.MediaStore.Images
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import com.simbir.kotlinpractice.R
import com.simbir.kotlinpractice.presentetion.presenter.ProfilePresenter
import com.simbir.kotlinpractice.presentetion.utils.OnClickPhotoDialogCallback
import com.simbir.kotlinpractice.presentetion.utils.PhotoChooseDialog
import com.simbir.kotlinpractice.presentetion.view.BaseFragment
import moxy.presenter.InjectPresenter

class ProfileFragment : BaseFragment(), ProfileView {

    private val DIALOG_FRAGMENT_TAG = "dialogPhotoChange"

    private val REQUEST_IMAGE_CAPTURE = 1
    private val REQUEST_IMAGE_FROM_GALLERY = 2
    private val BLANK_IMAGE = 0
    private val BLANK_IMAGE_WIDTH = 200

    @InjectPresenter
    lateinit var presenter: ProfilePresenter

    private lateinit var dialogFragment: DialogFragment
    private lateinit var profilePhoto: ImageView

    private val callback: OnClickPhotoDialogCallback = object : OnClickPhotoDialogCallback {

        override fun onClickProfileChoose() {
            val intent = Intent(Intent.ACTION_PICK, Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, REQUEST_IMAGE_FROM_GALLERY)
            dialogFragment.dismiss()
        }

        override fun onClickProfileNew() {
            val takeNewPhoto = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takeNewPhoto.resolveActivity(activity?.let { it.packageManager }) != null) {
                startActivityForResult(takeNewPhoto, REQUEST_IMAGE_CAPTURE)
            }
            dialogFragment.dismiss()
        }

        override fun onClickProfileDelete() {
            profilePhoto.setImageResource(BLANK_IMAGE)
            profilePhoto.layoutParams = LinearLayout.LayoutParams(
                BLANK_IMAGE_WIDTH,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            dialogFragment.dismiss()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_profile
    }


    override fun initViews(view: View) {
        profilePhoto = view.findViewById(R.id.profileImageUser)
        dialogFragment = PhotoChooseDialog()
        profilePhoto.setOnClickListener { onClickProfilePhoto(it) }
        setHasOptionsMenu(true)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && data != null && resultCode == Activity.RESULT_OK) {
            setNewPhoto(presenter.getPhotoProfile(data))
        } else if (requestCode == REQUEST_IMAGE_FROM_GALLERY && data != null && resultCode == Activity.RESULT_OK) {
            setPhotoFromGallery(presenter.getPhotoProfile(data))
        }
    }

    private fun setNewPhoto(bitmap: Bitmap) {
        profilePhoto.setImageBitmap(bitmap)
    }

    private fun setPhotoFromGallery(bitmap: Bitmap) {
        profilePhoto.setImageBitmap(bitmap)
    }

    private fun onClickProfilePhoto(view: View) {
        dialogFragment.show(fragmentManager!!, DIALOG_FRAGMENT_TAG)
    }

    fun getCallback(): OnClickPhotoDialogCallback {
        return callback
    }
}