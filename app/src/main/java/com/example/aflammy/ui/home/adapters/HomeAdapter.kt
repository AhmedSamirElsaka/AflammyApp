package com.example.aflammy.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.aflammy.R
import com.example.aflammy.ui.base.BaseAdapter
import com.example.aflammy.ui.base.BaseInteractionListener
import com.example.aflammy.ui.home.HomeItem

class HomeAdapter(
    private var homeItems: MutableList<HomeItem>,
    private val listener: BaseInteractionListener
) : BaseAdapter<HomeItem>(homeItems, listener) {
    override val layoutID: Int = 0


    override fun getItemViewType(position: Int): Int {
        if (homeItems.isNotEmpty()) {
            return when (homeItems[position]) {
                is HomeItem.Actor -> R.layout.list_actor
                is HomeItem.TvShows -> R.layout.list_tv_shows
                is HomeItem.Slider -> R.layout.list_popular
                is HomeItem.AiringToday -> R.layout.list_airing_today
                is HomeItem.OnTheAiring -> R.layout.list_tvshow
                is HomeItem.Adventure,
                is HomeItem.Mystery,
                is HomeItem.NowStreaming,
                is HomeItem.Trending,
                is HomeItem.Upcoming,
                -> R.layout.list_movie
            }
        }
        return -1
    }
}

fun setItem(item: HomeItem) {
    val newItems = homeItems.apply {
        removeAt(item.priority)
        add(item.priority, item)
    }

    setItems(newItems)
}

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
    return ItemViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), viewType, parent, false
        )
    )
}

override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
    if (homeItems.isNotEmpty())
        bind(holder as ItemViewHolder, position)
}

override fun bind(holder: ItemViewHolder, position: Int) {
    if (position != -1) {
        when (val currentItem = homeItems[position]) {

        }
    }
}
}