package com.example.aflammy.ui.adapters

import com.example.aflammy.R
import com.example.aflammy.domain.enums.HomeItemsType
import com.example.aflammy.ui.base.BaseAdapter
import com.example.aflammy.ui.base.BaseInteractionListener
import com.example.aflammy.ui.models.MediaUiState

class MovieAdapter(items: List<MediaUiState>, val listener: MovieInteractionListener) :
    BaseAdapter<MediaUiState>(items, listener) {
    override val layoutID: Int = R.layout.item_movie
}

interface MovieInteractionListener : BaseInteractionListener {
    fun onClickMovie(movieId: Int)
    fun onClickSeeAllMovie(homeItemsType: HomeItemsType)
}

