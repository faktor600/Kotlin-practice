package com.simbir.kotlinpractice.presentetion.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.simbir.kotlinpractice.R
import com.simbir.kotlinpractice.presentetion.view.viewholder.ViewHolderFilter
import com.simbir.kotlinpractice.presentetion.view.viewholder.ViewHolderHelp
import com.simbir.kotlinpractice.presentetion.view.viewholder.ViewHolderNews
import java.lang.IllegalArgumentException

class ViewHolderFactory {

    companion object{

        fun createViewHolder(view: View, layoutId: Int): RecyclerView.ViewHolder{
            return when(layoutId){
                R.layout.items_help_list -> ViewHolderHelp(view)
                R.layout.item_news -> ViewHolderNews(view)
                R.layout.item_filter -> ViewHolderFilter(view)
                else -> throw IllegalArgumentException("Неверный id разметки")
            }
        }
    }
}