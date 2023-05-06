package com.example.aflammy.ui.explore

import com.example.aflammy.R
import com.example.aflammy.ui.base.BaseAdapter
import com.example.aflammy.ui.base.BaseInteractionListener
import com.example.aflammy.ui.explore.exploreUIState.TrendyMediaUIState


class TrendAdapter(items: List<TrendyMediaUIState>, listener: TrendInteractionListener)
    : BaseAdapter<TrendyMediaUIState>(items, listener){
    override val layoutID: Int = R.layout.item_trend
}

interface TrendInteractionListener : BaseInteractionListener {
    fun onClickTrend(item: TrendyMediaUIState)
}