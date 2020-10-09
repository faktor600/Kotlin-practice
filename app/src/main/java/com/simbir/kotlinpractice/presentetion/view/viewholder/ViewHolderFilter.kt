package com.simbir.kotlinpractice.presentetion.view.viewholder

import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import com.simbir.kotlinpractice.R
import com.simbir.kotlinpractice.domain.Category
import com.simbir.kotlinpractice.presentetion.view.BaseViewHolder

class ViewHolderFilter(val view: View) : BaseViewHolder<Category>(view) {

    private lateinit var textFilter: TextView
    private lateinit var switchFilter: SwitchCompat
    private lateinit var layoutFilter: RelativeLayout

    init {
        textFilter = itemView.findViewById(R.id.textFilter)
        switchFilter = itemView.findViewById(R.id.switchFilter)
        layoutFilter = itemView.findViewById(R.id.layoutFilter)
    }

    override fun bind(item: Category) {
        textFilter.text = item.name
    }
}