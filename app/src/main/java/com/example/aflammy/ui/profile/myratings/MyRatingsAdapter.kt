package com.example.aflammy.ui.profile.myratings

import com.example.aflammy.R
import com.example.aflammy.ui.base.BaseAdapter
import com.example.aflammy.ui.base.BaseInteractionListener


class RatedMoviesAdapter(items: List<RatedUIState>, listener: RatedMoviesInteractionListener) :
    BaseAdapter<RatedUIState>(items, listener) {
    override val layoutID: Int = R.layout.item_rated_movie
}

interface RatedMoviesInteractionListener : BaseInteractionListener {
    fun onClickMovie(movieId: Int)
}