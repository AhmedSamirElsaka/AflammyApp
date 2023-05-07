package com.example.aflammy.ui.tvShowDetails

import com.example.aflammy.R
import com.example.aflammy.ui.base.BaseAdapter
import com.example.aflammy.ui.base.BaseInteractionListener
import com.example.aflammy.ui.tvShowDetails.tvShowUIState.TvShowSeasonUIState


class SeasonAdapterUIState(
    items: List<TvShowSeasonUIState>,
    listener: SeasonInteractionListener
) : BaseAdapter<TvShowSeasonUIState>(items, listener) {
    override val layoutID: Int = R.layout.item_season
}

interface SeasonInteractionListener : BaseInteractionListener {
    fun onClickSeason(seasonNumber: Int)
}
