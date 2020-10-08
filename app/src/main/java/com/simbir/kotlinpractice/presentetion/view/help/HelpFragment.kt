package com.simbir.kotlinpractice.presentetion.view.help

import android.view.View
import android.view.View.*
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simbir.kotlinpractice.BuildConfig
import com.simbir.kotlinpractice.R
import com.simbir.kotlinpractice.di.AppDatabaseModule
import com.simbir.kotlinpractice.di.InputStreamModule
import com.simbir.kotlinpractice.di.component.DaggerGetCategoriesComponent
import com.simbir.kotlinpractice.domain.Category
import com.simbir.kotlinpractice.presentetion.presenter.HelpPresenter
import com.simbir.kotlinpractice.presentetion.view.BaseFragment
import com.simbir.kotlinpractice.presentetion.view.adapter.HelpAdapter
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class HelpFragment : BaseFragment(), HelpView {

    private val MAX_COLUMNS: Int = 2

    @InjectPresenter
    lateinit var presenter: HelpPresenter

    @ProvidePresenter
    fun providePresenter(): HelpPresenter{
        val component = DaggerGetCategoriesComponent.builder()
            .inputStreamModule(
                this.context?.let {
                    InputStreamModule(it, BuildConfig.JSON_CATEGORIES_LIST)
                }
            )
            .appDatabaseModule(context?.let { AppDatabaseModule(it) })
            .build()

        return HelpPresenter(component.getCategoriesCase())
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var loadingText: TextView
    private lateinit var chooseCategory: TextView

    private lateinit var helpAdapter: HelpAdapter

    override fun getLayoutId(): Int {
        return R.layout.fragment_help
    }

    override fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.helpFragmentRecyclerViewItems)
        progressBar = view.findViewById(R.id.progressLoadingHelp)
        loadingText = view.findViewById(R.id.textLoadingHelp)
        chooseCategory = view.findViewById(R.id.helpFragmentTextCategoryChoose)
        recyclerView.layoutManager = GridLayoutManager(
            this.context,
            MAX_COLUMNS
        )

        helpAdapter = HelpAdapter()
        recyclerView.adapter = helpAdapter
    }

    override fun hideProgress() {
        progressBar.visibility = INVISIBLE
        loadingText.visibility = INVISIBLE
    }

    override fun setData(items: ArrayList<Category>) {
        chooseCategory.visibility = VISIBLE
        recyclerView.visibility = VISIBLE

        helpAdapter.updateItems(items)
    }
}