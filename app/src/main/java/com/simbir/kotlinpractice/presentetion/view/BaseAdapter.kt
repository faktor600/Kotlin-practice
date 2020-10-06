package com.simbir.kotlinpractice.presentetion.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.simbir.kotlinpractice.domain.DiffListItemModel
import com.simbir.kotlinpractice.presentetion.utils.ViewHolderFactory

abstract class BaseAdapter<T : DiffListItemModel, VH : BaseViewHolder<T>> : RecyclerView.Adapter<VH>() {

    private var items: ArrayList<T> = ArrayList()

    abstract fun getLayoutId(): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val id = getLayoutId()
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(id, parent, false)

        return ViewHolderFactory.createViewHolder(view, id) as VH
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }

    fun getData(): List<T>? {
        return items
    }

    fun add(item: T?) {
        item?.let { items.add(it) }
    }

    fun addAll(list: ArrayList<T>?) {
        list?.let { items.addAll(it) }
    }

    fun clearAll() {
        items.clear()
    }

    fun getItem(position: Int): T? {
        return items[position]
    }

    open fun updateItems(newList: ArrayList<T>) {
        val helper = DiffUtilHelper()
        helper.updateItems(newList)
    }

    inner class DiffUtilHelper{
        private var newList: ArrayList<T> = ArrayList()

        private val callback: DiffUtil.Callback = object : DiffUtil.Callback() {
            override fun getOldListSize(): Int {
                return items.size
            }

            override fun getNewListSize(): Int {
                return newList.size
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return items[oldItemPosition].isSameAs(newList[newItemPosition])
            }

            override fun areContentsTheSame(
                oldItemPosition: Int,
                newItemPosition: Int
            ): Boolean {
                return items[oldItemPosition] == newList[newItemPosition]
            }
        }

        private fun setNewList(newList: ArrayList<T>) {
            this.newList.addAll(newList)
        }

        fun updateItems(newList: ArrayList<T>) {
            setNewList(newList)
            val diffResult = DiffUtil.calculateDiff(callback)
            clearAll()
            addAll(newList)
            diffResult.dispatchUpdatesTo(this@BaseAdapter)
        }
    }
}