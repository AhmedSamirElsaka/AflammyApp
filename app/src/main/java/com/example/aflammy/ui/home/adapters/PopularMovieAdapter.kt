package com.example.aflammy.ui.home.adapters

import com.example.aflammy.R
import com.example.aflammy.ui.base.BaseAdapter
import com.example.aflammy.ui.home.HomeInteractionListener
import com.example.aflammy.ui.home.models.PopularUiState

class PopularMovieAdapter(items: List<PopularUiState>, listener: HomeInteractionListener) :
    BaseAdapter<PopularUiState>(items, listener) {
    override val layoutID: Int = R.layout.item_popular_movie
}

