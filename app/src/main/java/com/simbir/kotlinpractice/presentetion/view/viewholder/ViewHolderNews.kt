package com.simbir.kotlinpractice.presentetion.view.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.simbir.kotlinpractice.R
import com.simbir.kotlinpractice.domain.Event
import com.simbir.kotlinpractice.presentetion.view.BaseViewHolder
import com.squareup.picasso.Picasso

class ViewHolderNews(val view: View) : BaseViewHolder<Event>(view) {

    private val PUT_EVENT = "event"

    private lateinit var imageNews: ImageView
    private lateinit var newsTitle: TextView
    private lateinit var newsDescription: TextView
    private lateinit var newsDate: TextView

    init{
        imageNews = itemView.findViewById(R.id.imageNewsItem)
        newsTitle = itemView.findViewById(R.id.textNewsTitle)
        newsDescription = itemView.findViewById(R.id.textNewsDescription)
        newsDate = itemView.findViewById(R.id.textNewsDate)
    }

    override fun bind(item: Event) {
        val eventName: String = item.eventName
        newsTitle.text = eventName
        newsDescription.text = item.description
        newsDate.text = item.date
        
        Picasso.with(itemView.context)
            .load(item.imageUrls[0])
            .placeholder(R.drawable.image_man)
            .error(R.drawable.image_man)
            .into(imageNews)
    }
}