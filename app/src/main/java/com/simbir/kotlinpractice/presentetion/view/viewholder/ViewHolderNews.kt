package com.simbir.kotlinpractice.presentetion.view.viewholder

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.simbir.kotlinpractice.R
import com.simbir.kotlinpractice.domain.Event
import com.simbir.kotlinpractice.presentetion.utils.OnItemClickListener
import com.simbir.kotlinpractice.presentetion.view.BaseViewHolder
import com.simbir.kotlinpractice.presentetion.view.eventdetails.EventDetailsActivity
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

class ViewHolderNews(val view: View) : BaseViewHolder<Event>(view) {

    private val PUT_EVENT = "event"

    private lateinit var imageNews: ImageView
    private lateinit var newsTitle: TextView
    private lateinit var newsDescription: TextView
    private lateinit var newsDate: TextView

    private val onEventClickListener: OnItemClickListener<Event> = object: OnItemClickListener<Event>{
        override fun invoke(p1: Event) {
            val context = itemView.context
            val intent = Intent(context, EventDetailsActivity::class.java)
            intent.putParcelableArrayListExtra(PUT_EVENT, ArrayList(Collections.singleton(p1)))
            context.startActivity(intent)
        }
    }

    init{
        imageNews = itemView.findViewById(R.id.imageNewsItem)
        newsTitle = itemView.findViewById(R.id.textNewsTitle)
        newsDescription = itemView.findViewById(R.id.textNewsDescription)
        newsDate = itemView.findViewById(R.id.textNewsDate)
    }

    override fun bind(item: Event) {
        val eventName: String = item.eventName
        itemView.setOnClickListener{ onEventClickListener.invoke(item)  }
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