package com.example.aflammy.ui.search.adapters

import com.example.aflammy.R
import com.example.aflammy.ui.base.*
import com.example.aflammy.ui.search.mediaSearchUIState.SearchHistoryUIState


class SearchHistoryAdapter(items: List<SearchHistoryUIState>, listener: SearchHistoryInteractionListener)
    : BaseAdapter<SearchHistoryUIState>(items,listener){
    override val layoutID: Int = R.layout.item_search_history
}

interface SearchHistoryInteractionListener : BaseInteractionListener {
    fun onClickSearchHistory(name: String)
}