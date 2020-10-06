package com.simbir.kotlinpractice.presentetion.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.simbir.kotlinpractice.R
import com.simbir.kotlinpractice.presentetion.view.viewholder.ViewHolderHelp
import java.lang.IllegalArgumentException

class ViewHolderFactory {

    companion object{

        fun createViewHolder(view: View, layoutId: Int): RecyclerView.ViewHolder{
            return when(layoutId){
                R.layout.items_help_list -> ViewHolderHelp(view)
                else ->throw IllegalArgumentException("Неверный id разметки")
            }
        }
    }
}