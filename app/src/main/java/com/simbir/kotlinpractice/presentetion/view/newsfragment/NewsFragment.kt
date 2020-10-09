package com.simbir.kotlinpractice.presentetion.view.newsfragment

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.simbir.kotlinpractice.BuildConfig
import com.simbir.kotlinpractice.R
import com.simbir.kotlinpractice.di.AppDatabaseModule
import com.simbir.kotlinpractice.di.InputStreamModule
import com.simbir.kotlinpractice.di.component.DaggerGetCategoriesComponent
import com.simbir.kotlinpractice.di.component.DaggerGetEventComponent
import com.simbir.kotlinpractice.di.component.GetCategoriesComponent
import com.simbir.kotlinpractice.di.component.GetEventComponent
import com.simbir.kotlinpractice.domain.Category
import com.simbir.kotlinpractice.domain.Event
import com.simbir.kotlinpractice.presentetion.presenter.NewsPresenter
import com.simbir.kotlinpractice.presentetion.view.BaseFragment
import com.simbir.kotlinpractice.presentetion.view.adapter.FilterAdapter
import com.simbir.kotlinpractice.presentetion.view.adapter.NewsAdapter
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import kotlin.collections.ArrayList

class NewsFragment : BaseFragment(), NewsView {

    @InjectPresenter
    lateinit var newsPresenter: NewsPresenter

    @ProvidePresenter
    fun providePresenter(): NewsPresenter? {
        val context = context
        val componentEvent: GetEventComponent = DaggerGetEventComponent.builder()
            .inputStreamModule(context?.let { InputStreamModule(it, BuildConfig.JSON_EVENTS_LIST) })
            .appDatabaseModule(context?.let { AppDatabaseModule(it) })
            .build()
        val componentCategories: GetCategoriesComponent = DaggerGetCategoriesComponent.builder()
            .inputStreamModule(context?.let { InputStreamModule(it, BuildConfig.JSON_CATEGORIES_LIST) })
            .appDatabaseModule(context?.let { AppDatabaseModule(it) })
            .build()
        return NewsPresenter(componentEvent.getEventCase(), componentCategories.getCategoriesCase())
    }

    private lateinit var newsTitleString: String
    private lateinit var filterTitleString: String

    private lateinit var bottomNavigationView: BottomNavigationView

    private lateinit  var newsAdapter: NewsAdapter
    private lateinit var filterAdapter: FilterAdapter
    private lateinit var recyclerViewNews: RecyclerView
    private lateinit var recyclerViewFilter: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var loadingText: TextView
    private lateinit var title: TextView
    private lateinit var filterDescription: TextView
    private lateinit var buttonFilter: ImageView
    private lateinit var buttonAccept: ImageView
    private lateinit var buttonBack: ImageView

    override fun getLayoutId(): Int {
        return R.layout.fragment_news
    }


    override fun initViews(view: View) {
        recyclerViewNews = view.findViewById(R.id.recyclerViewNews)
        recyclerViewFilter = view.findViewById(R.id.filterRecyclerView)
        filterDescription = view.findViewById(R.id.filterCategoryHelp)
        bottomNavigationView = activity!!.findViewById(R.id.bottomNavigationView)
        progressBar = view.findViewById(R.id.progressLoadingNews)
        loadingText = view.findViewById(R.id.textLoadingNews)
        title = view.findViewById(R.id.actionBarTitle)
        buttonAccept = view.findViewById(R.id.iconAccept)
        buttonBack = view.findViewById(R.id.iconBack)
        buttonFilter = view.findViewById(R.id.newsFilterButton)
        newsTitleString = resources.getString(R.string.navigation_title_news)
        filterTitleString = resources.getString(R.string.filter_title)
        buttonFilter.setOnClickListener{ onClickFilter(it) }
        buttonBack.setOnClickListener{ onClickBack(it) }
        buttonAccept.setOnClickListener{ onClickAccept(it) }
        newsAdapter = NewsAdapter()
        filterAdapter = FilterAdapter()
        recyclerViewNews.adapter = newsAdapter
        recyclerViewFilter.adapter = filterAdapter
    }

    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
        loadingText.visibility = View.INVISIBLE
    }

    override fun setData(items: ArrayList<Event>) {
        recyclerViewNews.visibility = View.VISIBLE
        newsAdapter.updateItems(items)
    }

    override fun setCategories(items: ArrayList<Category>) {
        filterAdapter.updateItems(items)
    }

    private fun showNews() {
        title.text = newsTitleString
        bottomNavigationView.visibility = View.VISIBLE
        recyclerViewNews.visibility = View.VISIBLE
        buttonBack.visibility = View.INVISIBLE
        buttonAccept.visibility = View.INVISIBLE
        buttonFilter.visibility = View.VISIBLE
        filterDescription.visibility = View.INVISIBLE
        recyclerViewFilter.visibility = View.INVISIBLE
        bottomNavigationView.visibility = View.VISIBLE
    }

    private fun showFilter() {
        title.text = filterTitleString
        buttonBack.visibility = View.VISIBLE
        buttonAccept.visibility = View.VISIBLE
        buttonFilter.visibility = View.INVISIBLE
        bottomNavigationView.visibility = View.INVISIBLE
        filterDescription.visibility = View.VISIBLE
        recyclerViewFilter.visibility = View.VISIBLE
        recyclerViewNews.visibility = View.INVISIBLE
    }

    private fun onClickFilter(view: View) {
        showFilter()
    }

    private fun onClickBack(view: View) {
        showNews()
    }

    private fun onClickAccept(view: View) {
        newsAdapter.updateItems(
            ArrayList(newsPresenter.updateNewsItems(
                ArrayList(newsAdapter.getData()),
                ArrayList(checkCategories())
            ))
        )
        showNews()
    }

    private fun checkCategories(): ArrayList<String> {
        val listOfRequiredCategories =
            ArrayList<String>()
        for (category in filterAdapter.getData()!!) {
            val layout = recyclerViewFilter.findViewHolderForAdapterPosition(
                filterAdapter.getData()!!.indexOf(category)
            )!!.itemView
            val switchView: SwitchCompat = layout.findViewById(R.id.switchFilter)
            if (switchView.isChecked) {
                listOfRequiredCategories.add(category.name)
            }
        }
        return listOfRequiredCategories
    }
}