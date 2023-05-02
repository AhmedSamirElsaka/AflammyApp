package com.example.aflammy.ui.home.adapters

import com.example.aflammy.R
import com.example.aflammy.domain.enums.AllMediaType
import com.example.aflammy.ui.base.BaseAdapter
import com.example.aflammy.ui.base.BaseInteractionListener
import com.example.aflammy.ui.models.MediaUiState

class TVShowAdapter(items: List<MediaUiState>, val listener: TVShowInteractionListener) :
    BaseAdapter<MediaUiState>(items, listener) {
    override val layoutID: Int = R.layout.item_tvshow
}

interface TVShowInteractionListener : BaseInteractionListener {
    fun onClickTVShow(tVShowID: Int)
    fun onClickSeeTVShow(type: AllMediaType)
}

