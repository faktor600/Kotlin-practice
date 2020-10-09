package com.simbir.kotlinpractice.presentetion.view.eventdetails

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.simbir.kotlinpractice.R
import com.simbir.kotlinpractice.domain.Event
import com.simbir.kotlinpractice.presentetion.presenter.EventDetailsPresenter
import com.simbir.kotlinpractice.presentetion.view.BaseActivity
import com.squareup.picasso.Picasso
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class EventDetailsActivity : BaseActivity(), EventDetailsView{

    private val GET_EVENT = "event"
    private val EMAIL_SCHEME = "mailto"
    private val SHARE_TYPE = "text/plain"

    @InjectPresenter
    lateinit var presenter: EventDetailsPresenter

    @ProvidePresenter
    fun providePresenter(): EventDetailsPresenter{
        return EventDetailsPresenter(intent.getParcelableArrayListExtra<Event>(GET_EVENT)[0])
    }

    private lateinit var eventUrl: String
    private lateinit var eventEmail: String
    private lateinit var shareDescription: String

    private lateinit var toolbar: Toolbar
    private lateinit var eventTitle: TextView
    private lateinit var eventDate: TextView
    private lateinit var organizationName: TextView
    private lateinit var organizationLocation: TextView
    private lateinit var phoneNumbers: TextView
    private lateinit var description: TextView
    private lateinit var firstImage: ImageView
    private lateinit var secondImage: ImageView
    private lateinit var thirdImage: ImageView

    private lateinit var textTitle: TextView

    override fun getActivityLayoutId(): Int {
        return R.layout.activity_event_details
    }

    override fun getActionBarId(): Int {
        return R.layout.action_bar_event_detail
    }

    override fun initViews() {
        toolbar = findViewById(R.id.action_bar)

        textTitle = toolbar.findViewById(R.id.eventDetailsTitle)
        eventTitle = findViewById(R.id.eventTitle)
        organizationName = findViewById(R.id.eventOrganizationName)
        eventDate = findViewById(R.id.eventDate)
        organizationLocation = findViewById(R.id.eventOrganizationLocation)
        phoneNumbers = findViewById(R.id.eventPhoneNumbers)
        description = findViewById(R.id.eventDescription)
        firstImage = findViewById(R.id.eventDetailsFirstImage)
        secondImage = findViewById(R.id.eventSecondImage)
        thirdImage = findViewById(R.id.eventThirdImage)

        shareDescription = resources.getString(R.string.event_description_site)
    }

    override fun setContent(event: Event, date: String) {
        textTitle.text = event.eventName
        eventTitle.text = event.eventName
        eventDate.text = date
        organizationName.text = event.organizationName
        organizationLocation.text = event.location
        phoneNumbers.text = presenter.setPhoneNumbers(ArrayList(event.phoneNumbers))
        description.text = event.description
        eventEmail = event.eMail
        eventUrl = event.site
        val imageUrls: List<String> = event.imageUrls
        val picasso = Picasso.with(this)
        for (i in imageUrls.indices) {
            when (i) {
                0 ->  picasso.load(imageUrls[i])
                        .into(firstImage)
                1 -> picasso.load(imageUrls[i])
                        .into(secondImage)
                2 -> picasso.load(imageUrls[i])
                        .into(thirdImage)
            }
        }
    }

    fun onClickOpenEMailClient(view: View?) {
        val emailIntent = Intent(
            Intent.ACTION_SENDTO,
            Uri.fromParts(
                EMAIL_SCHEME,
                eventEmail,
                null
            )
        )
        startActivity(emailIntent)
    }

    fun onClickURLOpen(view: View?) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(eventUrl)))
    }

    fun onClickEventBack(view: View?) {
        finish()
    }

    fun onClickShare(view: View?) {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = SHARE_TYPE
        val shareBody: String = shareDescription + eventUrl
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, null))
    }
}