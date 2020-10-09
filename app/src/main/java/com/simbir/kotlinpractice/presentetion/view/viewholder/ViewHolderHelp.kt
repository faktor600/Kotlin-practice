package com.simbir.kotlinpractice.presentetion.view.viewholder

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.simbir.kotlinpractice.R
import com.simbir.kotlinpractice.domain.Category
import com.simbir.kotlinpractice.presentetion.view.BaseViewHolder


class ViewHolderHelp(view: View) : BaseViewHolder<Category>(view) {

    private val imageCategory: ImageView = view.findViewById(R.id.imageHelpItem)
    private val nameCategory: TextView = view.findViewById(R.id.textHelpItem)

    override fun bind(item: Category) {
        val context: Context = itemView.context
        nameCategory.text = item.name
        imageCategory.setImageResource(context.resources.getIdentifier(
            item.drawable,
            "drawable",
            context.applicationContext.packageName
        ))
    }
}