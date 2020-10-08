package com.simbir.kotlinpractice.presentetion.utils

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.simbir.kotlinpractice.R
import com.simbir.kotlinpractice.presentetion.view.mainactivity.MainActivity
import com.simbir.kotlinpractice.presentetion.view.profile.ProfileFragment

class PhotoChooseDialog : DialogFragment() {

    private lateinit var onClickPhotoDialogCallback: OnClickPhotoDialogCallback

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog: Dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_layout, container, false)

        val buttonChoose = view.findViewById<Button>(R.id.profileDialogButtonChoose)
        val buttonDelete = view.findViewById<Button>(R.id.profileDialogButtonDelete)
        val buttonNew = view.findViewById<Button>(R.id.profileDialogButtonNew)

        buttonChoose.setOnClickListener{ onClickPhotoDialogCallback.onClickProfileChoose() }
        buttonDelete.setOnClickListener { onClickPhotoDialogCallback.onClickProfileDelete() }
        buttonNew.setOnClickListener { onClickPhotoDialogCallback.onClickProfileNew() }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragments: List<Fragment> = (context as MainActivity).supportFragmentManager.fragments

        for(fragment in fragments){
            if(fragment is ProfileFragment){
                onClickPhotoDialogCallback = fragment.getCallback()
            }
        }
    }
}